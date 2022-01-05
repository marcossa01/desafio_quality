package com.desafio.desafiotesting.domain;

import com.desafio.desafiotesting.domain.Comodo;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class Bairro {

    private final String nome;
    private final BigDecimal valorMetroQuadrado;
}
