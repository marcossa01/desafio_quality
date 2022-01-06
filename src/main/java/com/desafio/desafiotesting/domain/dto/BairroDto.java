package com.desafio.desafiotesting.domain.dto;

import com.desafio.desafiotesting.domain.Bairro;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class BairroDto {
    @NotNull(message = "Nome do bairro é obrigatório")
    @NotEmpty(message = "Nome do bairro é obrigatório")
    @Size(min = 3, max = 45, message = "tamanho: mínimo 3, máximo 45")
    @Pattern(regexp = "^[A-Z][a-zA-Z0-9 ]+", message = "O nome do bairro deve começar com letra maiúscula")
    private final String nome;

    @Digits(integer = 11, fraction = 2, message = "O valor não pode ultrapassar 13 dígitos (11 inteiro e 2 decimais)")
    @NotNull(message = "Valor do m2 é obrigatório")
    @Positive(message = "O valor do m2 deve ser positivo")
    private final BigDecimal valorMetroQuadrado;

    public static Bairro converte(BairroDto bairro) {
        return new Bairro(bairro.getNome(), bairro.getValorMetroQuadrado());
    }

    public static BairroDto converte(Bairro bairro) {
        return new BairroDto(bairro.getNome(), bairro.getValorMetroQuadrado());
    }

    public static List<BairroDto> converteLista(List<Bairro> bairros) {
        return bairros.stream().map(BairroDto::converte).collect(Collectors.toList());
    }

    public static List<Bairro> converteListaDto(List<BairroDto> bairros) {
        return bairros.stream().map(BairroDto::converte).collect(Collectors.toList());
    }
}
