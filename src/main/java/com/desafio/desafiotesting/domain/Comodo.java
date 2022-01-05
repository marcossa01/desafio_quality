package com.desafio.desafiotesting.domain;

import java.io.Serializable;

public class Comodo implements Serializable {
    private static final long serialVersionUID = 7245102729388518152L;

    private String nome;
    private Double largura;
    private Double comprimento;

    public Comodo(){

    }

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
