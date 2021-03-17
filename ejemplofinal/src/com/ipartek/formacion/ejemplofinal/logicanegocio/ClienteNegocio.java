package com.ipartek.formacion.ejemplofinal.logicanegocio;

import com.ipartek.formacion.ejemplofinal.entidades.Cliente;

/**
 * Interfaz donde se crea la logica de negocio de los clientes
 * 
 * @author Jorge Gutierrez
 * @version 1.0
 */
public interface ClienteNegocio {

	/**
	 * Llamada a dar de alta un nuevo cliente
	 * @param cliente
	 */
	Cliente altaCliente(Cliente cliente);
}