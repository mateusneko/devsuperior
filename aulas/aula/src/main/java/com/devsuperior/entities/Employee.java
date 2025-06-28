package com.devsuperior.entities;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Employee {
    private String name;
    private double grossSalary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }
    public Employee(){

    }
    public Employee(String name, double grossSalary) {
        this.name = name;
        this.grossSalary = grossSalary;
    }
}
