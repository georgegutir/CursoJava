package com.ipartek.formacion.mf0223.accesodatos;

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
	default Iterable<T> obtenerTodos() {
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

}