package com.desafio.desafiotesting.domain.dto;

import java.io.Serializable;

public class CasaDto implements Serializable {
    private static final long serialVersionUID = 8960252552468131124L;

    private String nome;
    private String endereco;

    public CasaDto(){

    }

    public CasaDto(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}
