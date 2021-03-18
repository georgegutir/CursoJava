package com.ipartek.formacion.ejemplofinal.logicanegocio;

import com.ipartek.formacion.ejemplofinal.accesodatos.Dao;
import com.ipartek.formacion.ejemplofinal.accesodatos.DaoFabrica;
import com.ipartek.formacion.ejemplofinal.entidades.Cliente;

import lombok.extern.java.Log;

/**
 * La implementación de los métodos de ClienteNegocio
 * 
 * @author Jorge Gutierrez
 * @version 1.0
 */
@Log
public class ClienteNegocioImpl implements ClienteNegocio {
	private Dao<Cliente> dao = DaoFabrica.getDaoCliente();

	/**
	 * Llamada a dar de alta un nuevo cliente
	 * @param cliente	Cliente a guardar en la bbdd
	 * @return cliente	Cliente guardado
	 */
	@Override
	public Cliente altaCliente(Cliente cliente) {
		log.info(cliente.toString());
		return dao.insertar(cliente);
	}

}