package com.desafio.desafiotesting.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class CasaDto implements Serializable {
    private static final long serialVersionUID = 8960252552468131124L;

    private String nome;
    private String bairro;

}
