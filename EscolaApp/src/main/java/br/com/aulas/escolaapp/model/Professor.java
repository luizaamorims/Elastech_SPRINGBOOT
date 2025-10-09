package br.com.aulas.escolaapp.model;


import jakarta.persistence.*;

@Entity
@Table(name = "professores")
public class Professor {

    public Professor() {

    }

    public Professor(String nome) {
        this.nome = nome;
    }

    @Column
    private String nome;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
