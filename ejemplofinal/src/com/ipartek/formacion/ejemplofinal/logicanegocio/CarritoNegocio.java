package com.ipartek.formacion.ejemplofinal.logicanegocio;

import java.util.Set;

import com.ipartek.formacion.ejemplofinal.entidades.Factura;
import com.ipartek.formacion.ejemplofinal.entidades.Producto;

/**
 * Interfaz donde se declara la logica de negocio del carrito
 * 
 * @author Jorge Gutierrez
 * @version 1.0
 */
public interface CarritoNegocio {
	/**
	 * Llamada a listar todos los productos que hay en el carrito
	 * @return los productos del carrito
	 */
	Set<Producto> listadoProductos();
	
	/**
	 * Llamada a buscar los productos por su id
	 * @param id	 identificador
	 * @return 		 producto que coincide con el id
	 */
	Producto productoPorId(Long id);
	
	/**
	 * Llamada a guardar la factura de la compra
	 * @param factura	factura a guardar
	 * @return			factura ya guardada
	 */
	Factura guardarFactura(Factura factura);
}