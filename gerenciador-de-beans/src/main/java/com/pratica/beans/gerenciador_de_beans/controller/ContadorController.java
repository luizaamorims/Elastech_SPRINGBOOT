package com.pratica.beans.gerenciador_de_beans.controller;


import com.pratica.beans.gerenciador_de_beans.service.ContadorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContadorController {

    private ContadorService contadorService;


    public ContadorController(ContadorService contadorService){
        this.contadorService = contadorService;
    }


    @GetMapping("/contador")
    public int contador(){
        return contadorService.incrementar();
    }
}
