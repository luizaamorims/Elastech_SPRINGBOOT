package com.example.biblioteca.bibliotecaApp.service;


import com.example.biblioteca.bibliotecaApp.model.Livros;
import com.example.biblioteca.bibliotecaApp.repository.LivrosRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivrosService {


    @Autowired LivrosRepo livrosRepo;


    @Transactional
    public Livros salvar(Livros livros){
        return livrosRepo.save(livros);

    }

    public List<Livros> listarTodos(){
        return livrosRepo.findAll();
    }

    public void deletar(Integer id){
        livrosRepo.delete(livrosRepo.getById(id));
    }

    public void atualizar(Integer id){
        livrosRepo.save(livrosRepo.getById(id));
    }

    public Optional<Livros> buscarPorId(Integer id){
       return livrosRepo.findById(id);
    }






}
