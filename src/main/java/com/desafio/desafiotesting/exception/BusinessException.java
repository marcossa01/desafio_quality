package com.desafio.desafiotesting.exception;

import com.desafio.desafiotesting.resources.exceptions.StandardError;

public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = -88237426027806218L;

	public BusinessException(String msg) {
		super(msg);
	}
}
