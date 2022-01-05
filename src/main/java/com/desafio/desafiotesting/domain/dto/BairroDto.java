package com.desafio.desafiotesting.domain.dto;

import com.desafio.desafiotesting.domain.Bairro;
import com.desafio.desafiotesting.domain.Casa;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class BairroDto {
    @NotNull(message = "nome é obrigatório")
    @NotEmpty(message = "nome é obrigatório")
    @Size(min = 8, max = 45, message = "tamanho mínimo 8, máximo 45")
    @Pattern(regexp = "^[A-Z][a-zA-Z ]+", message = "O nome do comodo deve começar com letra maiúscula")
    private final String nome;

    @Digits(integer = 11, fraction = 2, message = "O valor não pode ultrapassar 13 dígitos - Casas decimais não pode ultrapassar dois dígitos")
    @NotNull(message = "Campo Obrigatório")
    @Positive(message = "O campo deve ser positivo")
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
