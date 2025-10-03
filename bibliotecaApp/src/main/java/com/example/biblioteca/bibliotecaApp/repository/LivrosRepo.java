package com.example.biblioteca.bibliotecaApp.repository;

import com.example.biblioteca.bibliotecaApp.model.Livros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivrosRepo extends JpaRepository <Livros, Integer>{
}
