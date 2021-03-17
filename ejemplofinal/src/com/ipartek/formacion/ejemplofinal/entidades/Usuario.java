package com.ipartek.formacion.ejemplofinal.entidades;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa los usuarios que pueden loguearse en la aplicación
 * 
 * @author Jorge Gutierrez
 * @version 1.0
 */
@Data @AllArgsConstructor @NoArgsConstructor
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 6810679589257920056L;
	
	private Long id;
	private String email;
	private String password;
	private Cliente cliente;
}