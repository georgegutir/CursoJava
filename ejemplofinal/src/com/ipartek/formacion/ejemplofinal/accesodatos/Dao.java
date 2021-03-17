package com.ipartek.formacion.ejemplofinal.accesodatos;

import java.util.Set;

/**
 * Interfaz con los métodos que se van a realizar a los datos
 * 
 * @author Jorge Gutierrez
 * @version 1.0
 */
public interface Dao<T> {
	/**
	 * Método para la obtención de todos los objetos
	 */
	default Set<T> obtenerTodos() {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	/**
	 * Método para la obtención de un objeto a través de su id
	 * @param id
	 */
	default T obtenerPorId(Long id) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	/**
	 * Método para la inserción de un nuevo objeto
	 * @param objeto
	 */
	default T insertar(T objeto) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	/**
	 * Método para la modificación de un objeto
	 * @param objeto
	 */
	default T modificar(T objeto) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	/**
	 * Método para borrar un objeto
	 * @param id
	 */
	default void borrar(Long id) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
}