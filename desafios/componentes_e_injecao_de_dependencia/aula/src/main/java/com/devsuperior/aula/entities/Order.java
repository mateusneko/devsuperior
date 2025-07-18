package com.devsuperior.aula.entities;

import jakarta.persistence.Entity;


public class Order {
    private int code;
    private double basic;
    private double discount;

    public Order(int code, double basic, double discount) {
        this.code = code;
        this.basic = basic;
        this.discount = discount;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public double getBasic() {
        return basic;
    }

    public void setBasic(double basic) {
        this.basic = basic;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotal(double shipping){
        return basic * (1- discount /100.0) + shipping;
    }
}
