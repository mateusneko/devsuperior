package com.devsuperior.desafio.dto;


import com.devsuperior.desafio.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class ClientDTO {
    private Long id;
    @NotBlank(message = "Digite um nome!")
    @Size(min = 3, max = 100, message = "O nome precisa conter entre 3 e 100 caracteres!")
    private String name;
    @Size(min = 11, max = 11, message = "O CPF deve conter exatamente 11 dígitos!")
    private String cpf;
    @Positive(message = "O valor deve ser maior que zero!")
    private Double income;
    @PastOrPresent
    private LocalDate birthDate;
    private Integer children;

    public ClientDTO(){

    }
    public ClientDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public ClientDTO(Client client){
        this.id = client.getId();
        this.name = client.getName();
        this.cpf = client.getCpf();
        this.income = client.getIncome();
        this.birthDate = client.getBirthDate();
        this.children = client.getChildren();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }
}