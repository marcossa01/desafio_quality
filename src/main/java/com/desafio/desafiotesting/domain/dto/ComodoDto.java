package com.desafio.desafiotesting.domain.dto;

import com.desafio.desafiotesting.domain.Comodo;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class ComodoDto {

    private final String nome;
    private final Double largura;
    private final Double comprimento;

    public static Comodo converte(ComodoDto comodoDto) {
        return new Comodo(comodoDto.getNome(),comodoDto.getLargura(),comodoDto.getComprimento());
    }

    public static ComodoDto converte(Comodo comodo) {
        return new ComodoDto(comodo.getNome(),comodo.getLargura(),comodo.getComprimento());
    }

    public static List<ComodoDto> converteLista(List<Comodo> comodos) {
        return comodos.stream().map(ComodoDto::converte).collect(Collectors.toList());
    }

    public static List<Comodo> converteListaDto(List<ComodoDto> comodos) {
        return comodos.stream().map(ComodoDto::converte).collect(Collectors.toList());
    }
}
