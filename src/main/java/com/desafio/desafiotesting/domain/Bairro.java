package com.desafio.desafiotesting.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bairro {
    private String nome;
    private BigDecimal valorMetroQuadrado;
}
