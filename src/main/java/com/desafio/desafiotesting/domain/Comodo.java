package com.desafio.desafiotesting.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Comodo implements Serializable {
    private static final long serialVersionUID = 7245102729388518152L;

    private final String nome;
    private final Double largura;
    private final Double comprimento;

    public double getAreaComodo() {
        return largura * comprimento;
    }
}
