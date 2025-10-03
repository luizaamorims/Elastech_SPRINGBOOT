package com.example.biblioteca.bibliotecaApp.controller;

import com.example.biblioteca.bibliotecaApp.model.Autor;
import com.example.biblioteca.bibliotecaApp.repository.AutorRepo;
import com.example.biblioteca.bibliotecaApp.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/autores")
public class PrimeiroController {


   @Autowired
    private AutorService autorService;


   @GetMapping("/{id}")
    public Optional<Autor> buscarPorId(@PathVariable("id") Integer id){
       return autorService.buscarPorId(id);
   }

   @PostMapping("/addAutor")
    public Autor salvar(@RequestBody Autor autor){
       System.out.println("Autor: " + autor);
        autorService.salvar(autor);
        return autor;
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") Integer id){
        autorService.deletar(id);
    }

    @PutMapping("{/id}")
    public void atualizar(@PathVariable("id") Integer id, @RequestBody Autor autor){
       autor.setId(id);
        autorService.atualizar(id);
    }
}
