package com.desafio.desafiotesting.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Casa {
    private String nome;
    private String bairro;
    private List<Comodo> comodos;
}
