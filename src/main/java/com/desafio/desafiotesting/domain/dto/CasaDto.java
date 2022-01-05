package com.desafio.desafiotesting.domain.dto;

import com.desafio.desafiotesting.domain.Casa;
import com.desafio.desafiotesting.domain.Comodo;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class CasaDto implements Serializable {
    private static final long serialVersionUID = 8960252552468131124L;

    private String nome;
    private String bairro;
    private List<ComodoDto> comodos;

}
