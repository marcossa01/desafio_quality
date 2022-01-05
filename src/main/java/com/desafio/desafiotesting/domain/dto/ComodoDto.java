package com.desafio.desafiotesting.domain.dto;

import com.desafio.desafiotesting.domain.Comodo;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class ComodoDto {

    /***
     * campo nome do comodo, retorna as validacoes solicitadas no documento fornecido
     *  1 - Que o campo nao poder estar vazio
     *  2 - Que comece com uma letra Maiuscula
     *  3 - Comprimento maximo de 30 caracteres.
     * @Autor: Leonardo *----*
     */
    @NotNull(message = "O campo nome e obrigatorio")
    @NotBlank(message = "O campo nao pode ser branco")
    @NotEmpty(message = "O campo nao pode ser vazio")
    @Pattern(regexp = "^[A-Z][a-z]+", message = "O nome da casa deve comecar com letra maiuscula")
    @Size(max = 30, message="O comprimeto do comodo nao pode exceder 30 caracteres")
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
