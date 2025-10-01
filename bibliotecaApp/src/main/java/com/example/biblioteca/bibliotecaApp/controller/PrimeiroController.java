package com.example.biblioteca.bibliotecaApp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeiroController {


    @RequestMapping("/ola")
    public String ola() {
        return "0la Spring Boot";
    }
}
