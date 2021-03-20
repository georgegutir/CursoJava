package com.ipartek.formacion.mf0223.accesodatos;

import com.ipartek.formacion.mf0223.entidades.Plato;
import com.ipartek.formacion.mf0223.entidades.Categoria;
import com.ipartek.formacion.mf0223.entidades.Procedencia;

/**
 * Métodos de acceso a los datos de la fábrica que se van a usar
 * 
 * @author Jorge Gutierrez
 * @version 1.0
 */
public class DaoFabrica {
	private DaoFabrica() {}

	private static final Dao<Plato> daoPlato = new PlatoDaoMySql();
	private static final Dao<Categoria> daoCategoria = new CategoriaDaoMySql();
	private static final Dao<Procedencia> daoProcedencia = new ProcedenciaDaoMySql();
	
	/**
	 * Método para la operación de obtención del Dao del plato
	 * @return daoPlato
	 */
	public static Dao<Plato> getDaoPlato() {
		return daoPlato;
	}
	
	/**
	 * Método para la operación de obtención del Dao de la categoria del plato
	 * @return daoCategoria
	 */
	public static Dao<Categoria> getDaoCategoria() {
		return daoCategoria;
	}
	
	/**
	 * Método para la operación de obtención del Dao de la procedencia del plato
	 * @return the daoProcedencia
	 */
	public static Dao<Procedencia> getDaoProcedencia() {
		return daoProcedencia;
	}

}
