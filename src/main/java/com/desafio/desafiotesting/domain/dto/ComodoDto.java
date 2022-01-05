package com.desafio.desafiotesting.domain.dto;

import com.desafio.desafiotesting.domain.Comodo;
import lombok.AllArgsConstructor;
import lombok.Data;


import javax.validation.constraints.*;
import java.util.List;
import java.util.stream.Collectors;

/***
 * @author Leonardo *----*
 * @author Fernando Netto
 */
@Data
@AllArgsConstructor
public class ComodoDto {

    /***
     * campo nome do comodo, retorna as validacoes solicitadas no documento fornecido
     *  1 - Que o campo nao poder estar vazio
     *  2 - Que comece com uma letra Maiúscula
     *  3 - Comprimento maximo de 30 caracteres.
     */
    @NotNull(message = "O campo nome e obrigatorio")
    @NotBlank(message = "O campo nao pode ser branco")
    @NotEmpty(message = "O campo nao pode ser vazio")
    @Pattern(regexp = "^[A-Z][a-zA-Z ]+", message = "O nome do comodo deve começar com letra maiuscula")
    @Size(max = 30, message="O comprimeto do comodo nao pode exceder 30 caracteres")
    private final String nome;

    /***
     * campo largura do comodo, retorna as validações solicitadas no documento fornecido
     *  1 - Que o campo nao pode estar nulo
     *  2 - Comprimento maximo de 25 metros.
     */
    @NotNull(message = "Largura é obrigatória")
    @Max(value = 25, message = "Largura não pode ser maior que 25 m")
    @Positive(message = "Largura deve ser maior que 0")
    private final Double largura;

    /***
     * campo largura do comodo, retorna as validacoes solicitadas no documento fornecido
     *  1 - Que o campo nao pode estar nulo
     *  2 - Comprimento maximo de 33 metros.
     */
    @NotNull(message = "Comprimento é obrigatória")
    @Max(value = 25, message = "Comprimento não pode ser maior que 33 m")
    @Positive(message = "Comprimento deve ser maior que 0")
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
