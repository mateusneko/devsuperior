package com.devsuperior.aula;

import com.devsuperior.entities.Employee;
import com.devsuperior.services.SalaryService;
import com.devsuperior.services.TaxService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AulaApplication implements CommandLineRunner {
	public AulaApplication(SalaryService salaryService) {
		this.salaryService = salaryService;
	}

	private SalaryService salaryService;

	public static void main(String[] args) {

		SpringApplication.run(AulaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee empregado = new Employee("Mateus", 4000);
		TaxService taxService = new TaxService();
		SalaryService salarioLiquido = new SalaryService();
		System.out.println(empregado.toString());
		System.out.println("Taxa: " + taxService.tax(empregado.getGrossSalary()));


	}
}
