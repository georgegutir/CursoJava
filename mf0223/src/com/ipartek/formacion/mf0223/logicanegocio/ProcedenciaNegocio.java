package com.ipartek.formacion.mf0223.logicanegocio;

import com.ipartek.formacion.mf0223.entidades.Procedencia;

/**
 * Interfaz donde se declaran los métodos de logica de negocio de procedencia
 * 
 * @author Jorge Gutierrez
 * @version 1.0
 */
public interface ProcedenciaNegocio {
	/**
	 * Llamada a listar todas las procedencias
	 * @return las procedencias de los platos
	 */
	Iterable<Procedencia> listadoProcedencia();
}
