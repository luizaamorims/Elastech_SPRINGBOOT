package com.example.biblioteca.bibliotecaApp.DTO;

import jakarta.validation.constraints.*;
import java.time.LocalDate;


public class AutorDTO {


    @NotEmpty
    @NotNull(message = "não pode ter nome nulo")
    private String nome;

    @NotNull(message = "campo invalido")
    private LocalDate data_Nascimento;

    @Pattern(regexp = "\\d{13}$", message = "o codigo deve conter 13 digitos numericos")
    private String isbn;

    public @NotEmpty String getNome() {
        return nome;
    }

    public void setNome(@NotEmpty String nome) {
        this.nome = nome;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getData_Nascimento() {
        return data_Nascimento;
    }

    public void setData_Nascimento(LocalDate data_Nascimento) {
        this.data_Nascimento = data_Nascimento;
    }
}
