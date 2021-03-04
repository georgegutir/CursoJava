package com.ipartek.formacion.ejemplofinal.entidades;

import java.time.LocalDate;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Factura {
	private Long id;
	private String codigo;
	private LocalDate fecha;

	private Cliente cliente; //1 factura puede tener 1 cliente

	private Set<DetalleFactura> detallesFactura; //1 cliente puede tener muchas facturas
}