package com.desafio.desafiotesting.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Casa implements Serializable {
    private static final long serialVersionUID = 8960252552468131124L;

    private String nome;
    private String endereco;
    private List<Comodo> comodos = new ArrayList<>();

    public Casa(){

    }

    public Casa(String nome, String endereco) {
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

    public List<Comodo> getComodos() {
        return comodos;
    }

    public void setComodos(List<Comodo> comodos) {
        this.comodos = comodos;
    }
}
