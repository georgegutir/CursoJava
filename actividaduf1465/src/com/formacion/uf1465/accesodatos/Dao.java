package com.formacion.uf1465.accesodatos;

public interface Dao<T> {
	default Iterable<T> obtenerTodos() {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
}
