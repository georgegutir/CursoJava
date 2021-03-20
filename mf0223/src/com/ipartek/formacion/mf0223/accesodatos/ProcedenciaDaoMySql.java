package com.ipartek.formacion.mf0223.accesodatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipartek.formacion.mf0223.entidades.Procedencia;

/**
 * Implementa los métodos del Dao en la procedencia
 * 
 * @author Jorge Gutierrez
 * @version 1.0
 */
public class ProcedenciaDaoMySql implements Dao<Procedencia> {
	private static final String SQL_SELECT = "SELECT id, nombre FROM procedencia";

	/**
	 * Obtiene de la bbdd todas las procedencias de los platos
	 * @return categorias
	 */
	@Override
	public Iterable<Procedencia> obtenerTodos() {
		try (Connection con = Config.dataSource.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(SQL_SELECT)) {
			ArrayList<Procedencia> procedencias = new ArrayList<>();
			Procedencia procedencia;

			while (rs.next()) {
				procedencia = new Procedencia(rs.getLong("id"), rs.getString("nombre"), null);
				procedencias.add(procedencia);
			}
			return procedencias;
		} catch (Exception e) {
			throw new AccesoDatosException("No se han podido obtener todas las procedencias", e);
		}
	}
}
