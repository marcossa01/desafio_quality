package com.desafio.desafiotesting.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Casa {
    private String nome;
    private String bairro;
    private List<Comodo> comodos;
}
