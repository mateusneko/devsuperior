package com.devsuperior.services;

import com.devsuperior.entities.Employee;
import org.springframework.stereotype.Service;

@Service
public class SalaryService {

    //Forma errada
    TaxService taxService = new TaxService();
    PensionService pensionService = new PensionService();
    public double netSalary(Employee employee){
    return employee.getGrossSalary() - taxService.tax(employee.getGrossSalary()) -
            pensionService.discount(employee.getGrossSalary());

    }
}
