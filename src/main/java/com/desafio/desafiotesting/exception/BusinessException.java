package com.desafio.desafiotesting.exception;

public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = -88237426027806218L;

	public BusinessException(String msg) {
		super(msg);
	}
}
