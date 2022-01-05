package com.desafio.desafiotesting.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
public class Comodo  {

    /***
     * campo nome do comodo, retorna as validacoes solicitadas no documento fornecido
     *  1 - Que o campo nao poder estar vazio
     *  2 - Que comece com uma letra Maiuscula
     *  3 - Comprimento maximo de 30 caracteres.
     * @Autor: Leonardo *----*
     */
    @NotNull(message = "O campo nao pode ser nulo")
    @NotEmpty(message = "O campo nao pode ser vazio")
    @NotBlank(message = "O campo nao pode ser branco")
    @Max(value = 30, message="O comprimeto do comodo nao pode exceder 30 caracteres")
    @Pattern(regexp = "^[A-Z][a-z]+")
    private final String nome;

    private final Double largura;
    private final Double comprimento;

    public double getAreaComodo() {
        return largura * comprimento;
    }
}
