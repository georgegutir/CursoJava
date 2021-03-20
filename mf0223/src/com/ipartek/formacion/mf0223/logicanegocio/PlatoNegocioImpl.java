package com.ipartek.formacion.mf0223.logicanegocio;

import com.ipartek.formacion.mf0223.accesodatos.Dao;
import com.ipartek.formacion.mf0223.accesodatos.DaoFabrica;
import com.ipartek.formacion.mf0223.entidades.Plato;

/**
 * La implementación de los métodos de PlatoNegocio
 * 
 * @author Jorge Gutierrez
 * @version 1.0
 */
public class PlatoNegocioImpl implements PlatoNegocio {
	private Dao<Plato> daoPlato = DaoFabrica.getDaoPlato();

	/**
	 * Llamada a sacar el listado de las categorías
	 * @return platos
	 */
	@Override
	public Iterable<Plato> listadoPlatos() {
		Iterable<Plato> platos = daoPlato.obtenerTodos();
		return platos;
	}

	/**
	 * Llamada a dar de alta un nuevo plato
	 * @param plato	plato a guardar en la bbdd
	 * @return plato	plato guardado
	 */
	@Override
	public Plato insertarPlato(Plato plato) {
		return daoPlato.insertar(plato);
	}

}
