package com.ipartek.formacion.ejemplofinal.logicanegocio;

/**
 * La fábrica en la que se crean las implementaciones de la lógica de negocio
 * 
 * @author Jorge Gutierrez
 * @version 1.0
 */
public class FabricaNegocio {
	private FabricaNegocio() {}

	private static final CarritoNegocio carritoNegocio = new CarritoNegocioImpl();
	private static final ClienteNegocio clienteNegocio = new ClienteNegocioImpl();
	private static final UsuarioNegocio usuarioNegocio = new UsuarioNegocioImpl();

	/**
	 * Se define la creación de carritoNegocio
	 * @return carritoNegocio
	 */
	public static CarritoNegocio getCarritoNegocio() {
		return carritoNegocio;
	}
	
	/**
	 * Se define la creación de clienteNegocio
	 * @return clienteoNegocio
	 */
	public static ClienteNegocio getClienteNegocio() {
		return clienteNegocio;
	}
	
	/**
	 * Se define la creación de usuarioNegocio
	 * @return usuarioNegocio
	 */
	public static UsuarioNegocio getUsuarioNegocio() {
		return usuarioNegocio;
	}
}