package com.desafio.desafiotesting.exception;

public class NullException extends NullPointerException{
    private static final long serialVersionUID = -7012775922197850149L;

    public NullException(String mensagem) {
        super(mensagem);
    }

}
