package com.desafio.desafiotesting.domain;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class Casa implements Serializable {
    private static final long serialVersionUID = 8960252552468131124L;

    private String nome;
    private String bairro;
    private List<Comodo> comodos;
}
