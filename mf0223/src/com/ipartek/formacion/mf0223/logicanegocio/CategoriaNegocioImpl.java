package com.ipartek.formacion.mf0223.logicanegocio;

import com.ipartek.formacion.mf0223.accesodatos.Dao;
import com.ipartek.formacion.mf0223.accesodatos.DaoFabrica;
import com.ipartek.formacion.mf0223.entidades.Categoria;

/**
 * La implementación de los métodos de CategoriaNegocio
 * 
 * @author Jorge Gutierrez
 * @version 1.0
 */
public class CategoriaNegocioImpl implements CategoriaNegocio {
	private Dao<Categoria> daoCategoria = DaoFabrica.getDaoCategoria();

	/**
	 * Llamada a sacar el listado de las categorías
	 * @return categorias
	 */
	@Override
	public Iterable<Categoria> listadoCategorias() {
		Iterable<Categoria> categorias = daoCategoria.obtenerTodos();
		return categorias;
	}

}
