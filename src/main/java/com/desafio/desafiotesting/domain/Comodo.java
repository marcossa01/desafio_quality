package com.desafio.desafiotesting.domain;

import javax.validation.constraints.*;
import java.io.Serializable;

public class Comodo implements Serializable {
    private static final long serialVersionUID = 7245102729388518152L;

    /***
     * campo nome do comodo, retorna as validacoes solicitadas no documento fornecido
     *  1 - Que o campo nao poder estar vazio
     *  2 - Que comece com uma letra Maiuscula
     *  3 - Comprimento maximo de 30 caracteres.
     * @Autor: Leonardo *----*
     */
    @NotNull(message = "O campo nao pode ser nulo")
    @NotEmpty(message = "O campo nao pode ser vazio")
    @NotBlank(message = "O campo nao pode ser branco")
    @Max(value = 30, message="O comprimeto do comodo nao pode exceder 30 caracteres")
    @Pattern(regexp = "^[A-Z][a-z]+")
    private String nome;

    private Double largura;
    private Double comprimento;

    public Comodo(String nome, Double largura, Double comprimento) {
        this.nome = nome;
        this.largura = largura;
        this.comprimento = comprimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getLargura() {
        return largura;
    }

    public void setLargura(Double largura) {
        this.largura = largura;
    }

    public Double getComprimento() {
        return comprimento;
    }

    public void setComprimento(Double comprimento) {
        this.comprimento = comprimento;
    }

    public double getAreaComodo() {
        return largura * comprimento;
    }
}
