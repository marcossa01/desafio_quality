package com.desafio.desafiotesting.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class BairroDto implements Serializable {
    private static final long serialVersionUID = 8960252552468131124L;

    private final String nome;
    private final BigDecimal valorMetroQuadrado;
}
