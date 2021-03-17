package com.ipartek.formacion.ejemplofinal.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa el detalle de la factura del precio total de cada producto
 * 
 * @author Jorge Gutierrez
 * @version 1.0
 */
@Data @NoArgsConstructor @AllArgsConstructor
public class DetalleFactura implements Serializable {
	private static final long serialVersionUID = 3924664355341140287L;
	
	private Factura factura;
	private Producto producto;
	private Integer cantidad;
	
	/**
	 * Calcula el precio total del producto relacionando su precio y la cantidad a comprar
	 * @return precio por cantidad
	 */
	public BigDecimal getTotal() {
		return producto.getPrecio().multiply(new BigDecimal(cantidad));
	}
}