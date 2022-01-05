package com.desafio.desafiotesting.domain.dto;

import com.desafio.desafiotesting.domain.Casa;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class CasaDto {

    @NotNull(message = "Campo obrigatório")
    @NotEmpty(message = "Campo não pode estar em branco")
    @Size(min = 8, max = 30, message = "tamanho min 8 e max 30")
    @Pattern(regexp = "^[A-Z][a-z]+", message = "Deve conter apenas letras, e primeira letra deve ser maiuscula")
    private String nome;

    @NotNull(message = "nome é obrigatório")
    @NotEmpty(message = "nome é obrigatório")
    @Size(min = 8, max = 45, message = "tamanho mínimo 8, máximo 55")
    @Pattern(regexp = "^[A-Z][a-zA-Z ]+", message = "O nome do bairro deve começar com letra maiúscula")
    private String bairro;

    @Valid
    @NotNull(message = "aluno deve ter disciplinas")
    private List<ComodoDto> comodos;

    public static Casa converte(CasaDto casa) {
        return new Casa(casa.getNome(), casa.getBairro(), ComodoDto.converteListaDto(casa.getComodos()));
    }

    public static CasaDto converte(Casa casa) {
        return new CasaDto(casa.getNome(), casa.getBairro(), ComodoDto.converteLista(casa.getComodos()));
    }

    public static List<CasaDto> converteLista(List<Casa> casas) {
        return casas.stream().map(CasaDto::converte).collect(Collectors.toList());
    }

    public static List<Casa> converteListaDto(List<CasaDto> casas) {
        return casas.stream().map(CasaDto::converte).collect(Collectors.toList());
    }
}
