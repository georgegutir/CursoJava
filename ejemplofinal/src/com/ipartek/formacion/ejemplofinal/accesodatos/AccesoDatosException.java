package com.ipartek.formacion.ejemplofinal.accesodatos;

/**
 * Coge las excepciones que se pueden encontrar y envía el mensaje
 * 
 * @author Jorge Gutierrez
 * @version 1.0
 */
public class AccesoDatosException extends RuntimeException {
	/**
	 * Constructor
	 */
	public AccesoDatosException() {
		super();
	}

	/**
	 * Constructor con parámetros de detalle del mensaje, la causa y supresiones y seguimiento activas o desactivadas
	 * @param message				mensaje de error
	 * @param cause					causa del error	
	 * @param enableSuppression		supresión
	 * @param writableStackTrace	seguimiento
	 */
	public AccesoDatosException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * Constructor con parámetros de detalle del mensaje y la causa
	 * @param message	mensaje de error
	 * @param cause		causa del error
	 */
	public AccesoDatosException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor con parámetros de detalle del mensaje
	 * @param message	mensaje de error
	 */
	public AccesoDatosException(String message) {
		super(message);
	}

	/**
	 * Constructor con parámetros de causa
	 * @param cause		causa del error
	 */
	public AccesoDatosException(Throwable cause) {
		super(cause);
	}

	private static final long serialVersionUID = -1699889400014234381L;
}
