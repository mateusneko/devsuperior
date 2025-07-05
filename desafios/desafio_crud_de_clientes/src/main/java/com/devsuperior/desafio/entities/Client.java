package com.devsuperior.desafio.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "tb_client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Digite um nome!")
    @Size(min = 3, max = 100, message = "O nome precisa conter entre 3 e 100 caracteres!")
    private String name;

    @Size(min = 11, max = 11, message = "O CPF deve conter exatamente 11 dígitos!")
    private String cpf;
    private Double income;
    @PastOrPresent
    private LocalDate birthDate;
    private Integer children;

    public Client() {
    }

    public Client(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Digite um nome!") @Size(min = 3, max = 100, message = "O nome precisa conter entre 3 e 100 caracteres!") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Digite um nome!") @Size(min = 3, max = 100, message = "O nome precisa conter entre 3 e 100 caracteres!") String name) {
        this.name = name;
    }

    public @Size(min = 11, max = 11, message = "O CPF deve conter exatamente 11 dígitos!") String getCpf() {
        return cpf;
    }

    public void setCpf(@Size(min = 11, max = 11, message = "O CPF deve conter exatamente 11 dígitos!") String cpf) {
        this.cpf = cpf;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public @PastOrPresent LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(@PastOrPresent LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }
}
