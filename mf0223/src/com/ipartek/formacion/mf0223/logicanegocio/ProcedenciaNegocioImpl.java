package com.ipartek.formacion.mf0223.logicanegocio;

import com.ipartek.formacion.mf0223.accesodatos.DaoFabrica;
import com.ipartek.formacion.mf0223.entidades.Procedencia;
import com.ipartek.formacion.mf0223.accesodatos.Dao;

/**
 * La implementación de los métodos de ProcedenciaNegocio
 * 
 * @author Jorge Gutierrez
 * @version 1.0
 */
public class ProcedenciaNegocioImpl implements ProcedenciaNegocio {
	private Dao<Procedencia> daoProcedencia = DaoFabrica.getDaoProcedencia();
	
	/**
	 * Llamada a sacar el listado de las procedencias
	 * @return procedencias
	 */
	@Override
	public Iterable<Procedencia> listadoProcedencia() {
		Iterable<Procedencia> procedencias = daoProcedencia.obtenerTodos();
		return procedencias;
	}
}
