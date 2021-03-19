package com.ipartek.formacion.mf0223.entidades;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa el pais de origen de clada plato
 * 
 * @author Jorge Gutierrez
 * @version 1.0
 */
@Data @AllArgsConstructor @NoArgsConstructor
public class Procedencia {
	private Long id;
	private String nombre;
	
	private Set<Plato> plato;
}