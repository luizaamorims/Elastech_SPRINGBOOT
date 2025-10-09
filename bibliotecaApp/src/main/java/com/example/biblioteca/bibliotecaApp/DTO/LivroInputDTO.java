package com.example.biblioteca.bibliotecaApp.DTO;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class LivroInputDTO {

    @NotBlank(message = "O título é obrigatório")
    @Size(min = 5, max = 100, message = "O título deve ter entre 5 e 100 caracteres")
    private String titulo;

    @NotBlank(message = "O ISBN é obrigatório")
    @Pattern(regexp = "^\\d{13}$", message = "O ISBN deve conter exatamente 13 dígitos numéricos")
    private String isbn;

    @NotNull(message = "O número de páginas é obrigatório")
    @Min(value = 10, message = "O livro deve ter no mínimo 10 páginas")
    @Max(value = 1000, message = "O livro deve ter no máximo 1000 páginas")
    private Integer numeroDePaginas;

    @NotNull(message = "O preço é obrigatório")
    @DecimalMin(value = "20.00", message = "O preço deve ser no mínimo R$ 20,00")
    private int preco;


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(Integer numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }
}
