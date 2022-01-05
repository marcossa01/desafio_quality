package com.desafio.desafiotesting.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Comodo  {
    private final String nome;
    private final Double largura;
    private final Double comprimento;

    public double getAreaComodo() {
        return largura*comprimento;
    }
}
