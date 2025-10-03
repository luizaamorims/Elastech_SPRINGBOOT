package com.aulasNovas.firstSpringApp.controller;

import com.aulasNovas.firstSpringApp.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.aulasNovas.firstSpringApp.repository.*;
import com.aulasNovas.firstSpringApp.service.PrimeiroService;

import java.util.UUID;


@RestController
@RequestMapping("/produto")
public class PrimeiroController {

    private ProdutoRepo produtorepo;

    public PrimeiroController(ProdutoRepo produtorepo) {
        this.produtorepo = produtorepo;
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        System.out.println("Produto: " + produto );
        var id = UUID.randomUUID().toString();
        produto.setId(null);
        produtorepo.save(produto);

        return produto;
    }

    @Autowired //Indica que preciso fazer uma DI
    private PrimeiroService primeiroService;


    @GetMapping("/{id}")
    public Produto obterPorId(@PathVariable("id") Integer id) {
        return produtorepo.findById(id).orElse(null);
    }

}
