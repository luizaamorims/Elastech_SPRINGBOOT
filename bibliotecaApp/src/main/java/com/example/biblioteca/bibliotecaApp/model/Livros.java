package com.example.biblioteca.bibliotecaApp.model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "livros")
public class Livros {


    public Livros(){
        super();
    }

    public Livros(Integer id, String titulo, LocalDate data_publicacao, Integer codigo_autor) {
        super();
        this.id = id;
        this.titulo = titulo;
        this.data_publicacao = data_publicacao;
        this.codigo_autor = codigo_autor;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    @Column(name = "data_publicacao")
    private LocalDate data_publicacao;

    @Column(name = "codigo_autor", nullable = false)
    private Integer codigo_autor;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodigo_autor() {
        return codigo_autor;
    }

    public void setCodigo_autor(Integer codigo_autor) {
        this.codigo_autor = codigo_autor;
    }

    public LocalDate getData_publicacao() {
        return data_publicacao;
    }

    public void setData_publicacao(LocalDate data_publicacao) {
        this.data_publicacao = data_publicacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Livros{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", data_publicacao=" + data_publicacao +
                ", codigo_autor=" + codigo_autor +
                '}';
    }
}
