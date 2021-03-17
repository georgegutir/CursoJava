package com.ipartek.formacion.ejemplofinal.entidades;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa los mensajes y niveles de alerta que dará la aplicación al introducir un usuario 
 * 
 * @author Jorge Gutierrez
 * @version 1.0
 */
@Data @NoArgsConstructor @AllArgsConstructor
public class Alerta implements Serializable {

	private static final long serialVersionUID = 4718434984524239877L;

	private String nivel;
	private String mensaje;
}