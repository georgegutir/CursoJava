package com.ipartek.formacion.mf0223.logicanegocio;

import com.ipartek.formacion.mf0223.entidades.Plato;

/**
 * Interfaz donde se declaran los métodos de logica de negocio de los platos
 * 
 * @author Jorge Gutierrez
 * @version 1.0
 */
public interface PlatoNegocio {
	/**
	 * Llamada a listar todos los platos
	 * @return los platos
	 */
	Iterable<Plato> listadoPlatos();
	
	/**
	 * Llamada a insertar un nuevo plato
	 * @param plato	plato a dar de alta
	 * @return plato plato guardado
	 */
	Plato insertarPlato(Plato plato);
}
