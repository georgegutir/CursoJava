package com.ipartek.formacion.uf1466Actividad2.accesodatos;

public interface Dao<T> {
	default Iterable<T> obtenerTodos() {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
	
	default T obtenerPorId(Long id) {
		throw new AccesoDatosException("METODO NO IMPLEMENTADPO");
	}

	default T obtenerPorISBN(String isbn) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

}
