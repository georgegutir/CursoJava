package com.ipartek.formacion.mf0223.logicanegocio;

/**
 * La fábrica en la que se crean las implementaciones de la lógica de negocio
 * 
 * @author Jorge Gutierrez
 * @version 1.0
 */
public class FabricaNegocio {
	private FabricaNegocio() {}
	
	private static PlatoNegocio platoNegocio = new PlatoNegocioImpl();
	private static CategoriaNegocio categoriaNegocio = new CategoriaNegocioImpl();
	private static ProcedenciaNegocio procedenciaNegocio = new ProcedenciaNegocioImpl();

	/**
	 * Se define la creación de platoNegocio
	 * @return platoNegocio
	 */
	public static PlatoNegocio getPlatoNegocio() {
		return platoNegocio;
	}
	
	/**
	 * Se define la creación de categoriaNegocio
	 * @return categoriaNegocio
	 */
	public static CategoriaNegocio getCategoriaNegocio() {
		return categoriaNegocio;
	}
	
	/**
	 * Se define la creación de procedenciaNegocio
	 * @return procedenciaNegocio
	 */
	public static ProcedenciaNegocio getProcedenciaNegocio() {
		return procedenciaNegocio;
	}
}
