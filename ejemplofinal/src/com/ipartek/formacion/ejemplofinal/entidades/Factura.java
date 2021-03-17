package com.ipartek.formacion.ejemplofinal.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Representa el recibo de la compra realizada
 * 
 * @author Jorge Gutierrez
 * @version 1.0
 */
@Data @NoArgsConstructor @AllArgsConstructor
public class Factura implements Serializable {

	private static final long serialVersionUID = 2396176411731906644L;
	private static final BigDecimal IVA = new BigDecimal("0.21");
	
	private Long id;
	private String codigo;
	private LocalDate fecha;

	private Cliente cliente; //1 factura puede tener 1 cliente

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Set<DetalleFactura> detallesFactura = new HashSet<>(); //1 cliente puede tener muchas facturas
	
	/**
	 * Calcula el precio total de la compra
	 * @return precio total de la compra
	 */
	public BigDecimal getTotal() {
		BigDecimal total = BigDecimal.ZERO;

		for(DetalleFactura detalle: detallesFactura) {
			total = total.add(detalle.getTotal());
		}

		return total;
	}

	/**
	 * Calcula y añade el IVA al precio total
	 * @return precio con el IVA añadido
	 */
	public BigDecimal getIva() {
		return getTotal().multiply(IVA);
	}

	/**
	 * Calcula el IVA total
	 * @return precio total con el IVA añadido
	 */
	public BigDecimal getTotalConIva() {
		return getTotal().add(getIva());
	}
}