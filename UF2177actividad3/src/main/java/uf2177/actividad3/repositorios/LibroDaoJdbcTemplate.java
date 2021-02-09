package uf2177.actividad3.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import uf2177.actividad3.entidades.Libro;

@Repository
public class LibroDaoJdbcTemplate implements Dao<Libro>{
	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public Iterable<Libro> obtenerTodos() {
		return jdbc.query(
				"Select l.id, l.nombre, CONCAT(a.nombre,' ',a.apellidos) from libros l join autores a on l.autores_id = a.id", 
				(rs, rowNum) -> new Libro(rs.getLong("l.id"), rs.getString("l.nombre"), rs.getString("CONCAT(a.nombre,' ',a.apellidos)")));
	}

}
