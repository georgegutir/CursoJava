package com.ipartek.formacion.mf0223.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipartek.formacion.mf0223.entidades.Categoria;
import com.ipartek.formacion.mf0223.entidades.Plato;
import com.ipartek.formacion.mf0223.entidades.Procedencia;

/**
 * Implementa los métodos del Dao en los platos
 * 
 * @author Jorge Gutierrez
 * @version 1.0
 */
public class PlatoDaoMySql implements Dao<Plato>{
	private static final String SQL_SELECT = "SELECT p.id AS id, p.nombre AS nombre, p.calorias AS calorias, c.nombre AS categoria, pr.nombre AS procedencia\r\n"
			+ "FROM plato p JOIN categoria c ON p.categoria_id = c.id\r\n"
			+ "JOIN procedencia pr ON p.procedencia_id = pr.id";
	private static final String SQL_INSERT = "INSERT INTO plato (nombre, calorias, categoria_id, procedencia_id) VALUES (?, ?, ?, ?)";
	
	/**
	 * Obtiene de la bbdd todos los platos
	 * @return platos
	 */
	@Override
	public Iterable<Plato> obtenerTodos() {
		try (Connection con = Config.dataSource.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(SQL_SELECT + " ORDER BY p.id ASC")) {
			ArrayList<Plato> platos = new ArrayList<>();

			Plato plato;
			Categoria categoria;
			Procedencia procedencia;

			while (rs.next()) {
				categoria = new Categoria(rs.getLong("c.id"), rs.getString("c.nombre"));
				procedencia = new Procedencia(rs.getLong("p.id"), rs.getString("o.nombre"));

				plato = new Plato(rs.getLong("id"), rs.getString("nombre"), rs.getInt("calorias"), categoria, procedencia);
				platos.add(plato);
			}
			return platos;
		} catch (Exception e) {
			throw new AccesoDatosException("No se han podido obtener todos los platos", e);
		}
	}

	/**
	 * Inserta en la bbdd el nuevo plato introducido
	 * @param plato 
	 * @return plato 
	 */
	@Override
	public Plato insertar(Plato plato) {
		try (Connection con = Config.dataSource.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_INSERT);) {

			pst.setString(1, plato.getNombre());
			pst.setInt(2, plato.getCalorias());
			pst.setLong(3, plato.getCategoria().getId());
			pst.setLong(4, plato.getProcedencia().getId());

			if (pst.executeUpdate() != 1) {
				throw new AccesoDatosException("Ha habido una incidencia en la inserción del plato: " + plato);
			}

			return plato;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido insertar el plato: " + plato, e);
		} catch (Exception e) {
			throw new AccesoDatosException("Error al insertar el plato: " + plato, e);
		}
	}

}
