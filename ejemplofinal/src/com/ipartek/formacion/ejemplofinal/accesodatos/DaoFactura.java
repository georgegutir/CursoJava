package com.ipartek.formacion.ejemplofinal.accesodatos;

import com.ipartek.formacion.ejemplofinal.entidades.Factura;

/**
 * Interfaz con los métodos de acceso a los datos de la factura 
 * 
 * @author Jorge Gutierrez
 * @version 1.0
 */
public interface DaoFactura extends Dao<Factura> {

	/**
	 * Método para obtener el último código creado en una factura
	 */
	String obtenerUltimoCodigo();
}