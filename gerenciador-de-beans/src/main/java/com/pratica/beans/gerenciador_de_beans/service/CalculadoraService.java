package com.pratica.beans.gerenciador_de_beans.service;


import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;


@Service
public class CalculadoraService {


    public int somar(int a, int b){
        return a + b;
    }

    @PostConstruct
    public void init(){
        System.out.println("bean foi criado");
    }
}
