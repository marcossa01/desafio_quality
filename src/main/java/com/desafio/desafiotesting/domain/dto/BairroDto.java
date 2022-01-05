package com.desafio.desafiotesting.domain.dto;

import com.desafio.desafiotesting.domain.Bairro;
import com.desafio.desafiotesting.domain.Casa;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class BairroDto {

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
}
