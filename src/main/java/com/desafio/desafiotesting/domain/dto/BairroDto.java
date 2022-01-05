package com.desafio.desafiotesting.domain.dto;

import com.desafio.desafiotesting.domain.Bairro;
import com.desafio.desafiotesting.domain.Casa;
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

    public static Bairro converte(BairroDto bairro) {
        return new Bairro(bairro.getNome(), bairro.getValorMetroQuadrado());
    }

    public static BairroDto converte(Bairro bairro) {
        return new BairroDto(bairro.getNome(), bairro.getValorMetroQuadrado());
    }
}
