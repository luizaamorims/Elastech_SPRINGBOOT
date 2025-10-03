package com.example.biblioteca.bibliotecaApp.service;

import com.example.biblioteca.bibliotecaApp.model.Autor;
import com.example.biblioteca.bibliotecaApp.repository.AutorRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AutorService {
    @Autowired
    private AutorRepo repository;

    @Transactional
    public Autor salvar(Autor autor){
        return repository.save(autor);
    }

    public Optional<Autor> buscarPorId(Integer id){
        return repository.findById(id);
    }

    public List<Autor> listarTodos(){
        return repository.findAll();
    }

    public void deletar(Integer id){
        repository.deleteById(id);
    }

    public void atualizar(Integer id){
        repository.save(repository.getById(id));
    }

}
