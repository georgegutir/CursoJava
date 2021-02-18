package com.ipartek.formacion.usuarioservlets.controladores;

public class ControladoresException extends RuntimeException {

	private static final long serialVersionUID = -476697954479250343L;

	public ControladoresException() {
		super();
	}

	public ControladoresException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ControladoresException(String message, Throwable cause) {
		super(message, cause);
	}

	public ControladoresException(String message) {
		super(message);
	}

	public ControladoresException(Throwable cause) {
		super(cause);
	}

}