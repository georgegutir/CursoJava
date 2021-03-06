package com.ipartek.formacion.uf1466Actividad2.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Libro {
	private Long id;
	private String titulo;
	private String isbn;

	private Autor autor;
}
