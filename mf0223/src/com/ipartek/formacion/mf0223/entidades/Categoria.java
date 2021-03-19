package com.ipartek.formacion.mf0223.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa la categoría que tiene cada plato
 * 
 * @author Jorge Gutierrez
 * @version 1.0
 */
@Data @AllArgsConstructor @NoArgsConstructor
public class Categoria {	
	private Long id;
	private String nombre;
}