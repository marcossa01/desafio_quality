package com.desafio.desafiotesting.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Bairro {
    private final String nome;
    private final BigDecimal valorMetroQuadrado;
}
