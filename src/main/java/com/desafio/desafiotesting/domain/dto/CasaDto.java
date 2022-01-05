package com.desafio.desafiotesting.domain.dto;

import com.desafio.desafiotesting.domain.Casa;
import com.desafio.desafiotesting.domain.Comodo;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class CasaDto implements Serializable {
    private static final long serialVersionUID = 8960252552468131124L;

    private String nome;
    private String bairro;
    private List<ComodoDto> comodos;

    public static Casa converte(CasaDto casa) {
        return new Casa(casa.getNome(), casa.getBairro(), ComodoDto.converteListaDto(casa.getComodos()));
    }

    public static CasaDto converte(Casa casa) {
        return new CasaDto(casa.getNome(), casa.getBairro(), ComodoDto.converteLista(casa.getComodos()));
    }

    public static List<Casa> converteListaDto(List<CasaDto> casas) {
        return casas.stream().map(CasaDto::converte).collect(Collectors.toList());
    }

    public static List<CasaDto> converteLista(List<Casa> casas) {
        return casas.stream().map(CasaDto::converte).collect(Collectors.toList());
    }
}
