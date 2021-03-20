package com.ipartek.formacion.mf0223.controladores;

import com.ipartek.formacion.mf0223.logicanegocio.CategoriaNegocio;
import com.ipartek.formacion.mf0223.logicanegocio.FabricaNegocio;
import com.ipartek.formacion.mf0223.logicanegocio.PlatoNegocio;
import com.ipartek.formacion.mf0223.logicanegocio.ProcedenciaNegocio;

/**
 * Controlador de configuración de la aplicación
 * 
 * @author Jorge Gutierrez
 * @version 1.0
 */
public class Config {
	private Config() {
	}

	static final String PATH_VISTAS = "/WEB-INF/vistas/";
	static final String UPLOAD_DIRECTORY = "database_backup";
	static final PlatoNegocio platoNegocio = FabricaNegocio.getPlatoNegocio();
	static final CategoriaNegocio categoriaNegocio = FabricaNegocio.getCategoriaNegocio();
	static final ProcedenciaNegocio procedenciaNegocio = FabricaNegocio.getProcedenciaNegocio();
	
}
