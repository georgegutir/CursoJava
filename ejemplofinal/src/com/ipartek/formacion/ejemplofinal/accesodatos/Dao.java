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
	 * @return Todos los objetos
	 */
	default Set<T> obtenerTodos() {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	/**
	 * Método para la obtención de un objeto a través de su id
	 * @param id	identificador del objeto
	 * @return objeto relacionado con id
	 */
	default T obtenerPorId(Long id) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	/**
	 * Método para la inserción de un nuevo objeto
	 * @param objeto	nuevo objeto a guardar en la bbdd
	 * @return objeto con su id actualizado
	 */
	default T insertar(T objeto) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	/**
	 * Método para la modificación de un objeto
	 * @param objeto	objeto ya existente con los nuevos datos a modificar
	 * @return objeto ya modificado
	 */
	default T modificar(T objeto) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	/**
	 * Método para borrar un objeto
	 * @param id	identificador del objeto
	 */
	default void borrar(Long id) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
}