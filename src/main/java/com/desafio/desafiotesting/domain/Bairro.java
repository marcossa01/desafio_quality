package com.desafio.desafiotesting.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Bairro {

    private String nome;
    private BigDecimal valorMetroQuadrado;
}
