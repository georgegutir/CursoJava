package com.ipartek.formacion.uf1466Actividad2.accesodatos;

import com.ipartek.formacion.uf1466Actividad2.entidades.Libro;

public interface LibroDao extends Dao<Libro> {
	default Iterable<Libro> obtenerPorTitulo(String titulo) {
		throw new AccesoDatosException("ESTE MÉTODO NO ESTÁ IMPLEMENTADO");
	}
}
