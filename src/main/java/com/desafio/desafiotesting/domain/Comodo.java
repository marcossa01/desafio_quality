package com.desafio.desafiotesting.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Comodo  {
    private String nome;
    private Double largura;
    private Double comprimento;

    public double getAreaComodo() {
        return largura * comprimento;
    }
}
