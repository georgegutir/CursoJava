package com.ipartek.formacion.mf0223.logicanegocio;

import com.ipartek.formacion.mf0223.entidades.Categoria;

/**
 * Interfaz donde se declaran los métodos de logica de negocio de categoría
 * 
 * @author Jorge Gutierrez
 * @version 1.0
 */
public interface CategoriaNegocio {
	/**
	 * Llamada a listar todas las categorías
	 * @return las categorias de los platos
	 */
	Iterable<Categoria> listadoCategorias();
}
