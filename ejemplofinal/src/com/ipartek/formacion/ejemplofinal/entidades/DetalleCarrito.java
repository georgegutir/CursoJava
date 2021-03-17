package com.ipartek.formacion.ejemplofinal.entidades;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa la cantidad comprada de cada producto
 * 
 * @author Jorge Gutierrez
 * @version 1.0
 */
@Data @NoArgsConstructor @AllArgsConstructor
public class DetalleCarrito implements Serializable {
	private static final long serialVersionUID = 8457880439062947651L;

	private Producto producto;
	private Integer cantidad;
}