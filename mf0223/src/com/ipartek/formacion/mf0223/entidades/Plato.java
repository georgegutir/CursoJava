package com.ipartek.formacion.mf0223.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa las comidas
 * 
 * @author Jorge Gutierrez
 * @version 1.0
 */
@Data @NoArgsConstructor @AllArgsConstructor
public class Plato {
	private long id;
	private String nombre;
	private int calorias;
	
	private Categoria categoria;
	private Procedencia procedencia;
}
