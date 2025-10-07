package com.pratica.beans.gerenciador_de_beans.service;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

@Service
@RequestScope()
public class ContadorService {
    private int contador = 0;

    public int incrementar(){
        return ++contador;
    }
}
