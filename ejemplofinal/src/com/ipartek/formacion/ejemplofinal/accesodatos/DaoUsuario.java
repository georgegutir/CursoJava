package com.ipartek.formacion.ejemplofinal.accesodatos;

import com.ipartek.formacion.ejemplofinal.entidades.Usuario;

/**
 * Interfaz con los métodos de acceso a los datos del usuario
 * 
 * @author Jorge Gutierrez
 * @version 1.0
 */
public interface DaoUsuario extends Dao<Usuario>{
	/**
	 * Buscar y obtener al usuario buscado a través del email introducido
	 * @param email
	 */
	Usuario obtenerPorEmail(String email);
}