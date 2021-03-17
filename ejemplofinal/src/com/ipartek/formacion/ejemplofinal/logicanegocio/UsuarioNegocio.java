package com.ipartek.formacion.ejemplofinal.logicanegocio;

import com.ipartek.formacion.ejemplofinal.entidades.Usuario;

/**
 * Interfaz donde se declara la logica de negocio de los usuarios
 * 
 * @author Jorge Gutierrez
 * @version 1.0
 */
public interface UsuarioNegocio {
	/**
	 * Llamada a la validación de usuario
	 * @param usuario
	 */
	boolean validarUsuario(Usuario usuario);
}