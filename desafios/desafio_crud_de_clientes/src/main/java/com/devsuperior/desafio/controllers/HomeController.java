package com.devsuperior.desafio.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Bem-vindo! " +
                "O Desafio 3 - CRUD de clientes está rodando perfeitamente!";
    }
}
