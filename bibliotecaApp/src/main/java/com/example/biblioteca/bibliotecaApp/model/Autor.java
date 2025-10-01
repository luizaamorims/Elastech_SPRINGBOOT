package com.example.biblioteca.bibliotecaApp.model;


import jakarta.persistence.*;
import java.time.*;

import java.time.LocalDate;

@Entity
@Table(name = "autores")
public class Autor {

    public Autor() {
        super();
    }

    public Autor(Integer Id, LocalDate data_nascimento) {
        super();
        this.id = id;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "data_nascimento")
    private LocalDate data_nascimento;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}


