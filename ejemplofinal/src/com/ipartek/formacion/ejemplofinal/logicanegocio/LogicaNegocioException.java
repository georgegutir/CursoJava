package com.ipartek.formacion.ejemplofinal.logicanegocio;

/**
 * Coge las excepciones que se pueden encontrar en la lógica de negocio y envía el mensaje
 * 
 * @author Jorge Gutierrez
 * @version 1.0
 */
public class LogicaNegocioException extends RuntimeException {

	private static final long serialVersionUID = -6177389577332893172L;

	/**
	 * Constructor
	 */
	public LogicaNegocioException() {
		super();
	}

	/**
	 * Constructor con parámetros de detalle del mensaje, la causa y supresiones y seguimiento activas o desactivadas
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public LogicaNegocioException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * Constructor con parámetros de detalle del mensaje y la causa
	 * @param message
	 * @throws cause
	 */
	public LogicaNegocioException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor con parámetros de detalle del mensaje
	 * @param message
	 */
	public LogicaNegocioException(String message) {
		super(message);
	}

	/**
	 * Constructor con parámetros de causa
	 * @throws causa
	 */
	public LogicaNegocioException(Throwable cause) {
		super(cause);
	}


}