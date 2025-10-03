package com.example.biblioteca.bibliotecaApp.service;


import com.example.biblioteca.bibliotecaApp.model.Livros;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivrosService {


    @Autowired LivrosService livrosService;


    @Transactional
    public Livros salvar(Livros livros){
        return livrosService.salvar(livros);

    }

    public List<Livros> listarTodos(){
        return livrosService.listarTodos();
    }

    public void deletar(Integer id){
        livrosService.deletar(id);
    }

    public void atualizar(Integer id){
        livrosService.atualizar(id);
    }

    public Optional<Livros> buscarPorId(Integer id){
        return livrosService.buscarPorId(id);
    }






}
