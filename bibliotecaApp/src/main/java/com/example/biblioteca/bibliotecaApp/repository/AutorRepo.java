package com.example.biblioteca.bibliotecaApp.repository;

import com.example.biblioteca.bibliotecaApp.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface AutorRepo extends JpaRepository<Autor, Integer> {



}
