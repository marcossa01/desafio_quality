package com.desafio.desafiotesting.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comodo  {
    private String nome;
    private Double largura;
    private Double comprimento;

    public double calculaAreaComodo() {
        return largura * comprimento;
    }
}
