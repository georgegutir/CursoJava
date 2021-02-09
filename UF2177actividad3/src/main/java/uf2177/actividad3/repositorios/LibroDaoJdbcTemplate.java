package uf2177.actividad3.repositorios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import uf2177.actividad3.entidades.Libro;
import uf2177.actividad3.entidades.Resena;

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

	@Override
	public Libro obtenerPorId(long id) {
		return jdbc.queryForObject(
				"SELECT * from libro where id = ?", new BeanPropertyRowMapper<Libro>(Libro.class), id);
	}

	@Override
	public Libro obtenerPorIdConResenas(long id) {
		Libro libro = obtenerPorId(id);
		List<Resena> resenas = jdbc.query(
				"SELECT r.id, r.texto, r.libros_id FROM resenas r inner join libros l on r.libros_id = l.id WHERE l.id = ?",
				(rs, rowNum) -> new Resena(rs.getLong("r.id"), rs.getString("r.texto"), rs.getLong("r.libros_id")), id);
		
		libro.getResenas().addAll(resenas);

		return libro;
	}

}
