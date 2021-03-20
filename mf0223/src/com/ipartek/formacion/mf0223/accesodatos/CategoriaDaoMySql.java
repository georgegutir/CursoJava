package com.ipartek.formacion.mf0223.accesodatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipartek.formacion.mf0223.entidades.Categoria;

/**
 * Implementa los métodos del Dao en la categoría
 * 
 * @author Jorge Gutierrez
 * @version 1.0
 */
public class CategoriaDaoMySql implements Dao<Categoria> {
	private static final String SQL_SELECT = "SELECT id, nombre FROM categoria";

	/**
	 * Obtiene de la bbdd todas las categorias
	 * @return categorias
	 */
	@Override
	public Iterable<Categoria> obtenerTodos() {
		try (Connection con = Config.dataSource.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(SQL_SELECT)) {
			ArrayList<Categoria> categorias = new ArrayList<>();
			Categoria categoria;

			while (rs.next()) {
				categoria = new Categoria(rs.getLong("id"), rs.getString("nombre"), null);
				categorias.add(categoria);
			}
			return categorias;
		} catch (Exception e) {
			throw new AccesoDatosException("No se han podido obtener todas las categorías", e);
		}
	}
}
