package uf2177.actividad3.repositorios;

import java.sql.PreparedStatement;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import uf2177.actividad3.entidades.Resena;

@Repository
public class ResenaDaoJdbcTemplate {
	@Autowired
	private JdbcTemplate jdbc;
	
	//public Resena obtenerPorId(long id) {
	//	return (Resena) jdbc.query("SELECT * FROM resenas WHERE id = ?", new BeanPropertyRowMapper<Resena>(Resena.class), id);	
	//}
	
	public Resena insertar(Resena resena) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbc.update(connection -> {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO resenas (texto, libros_id) VALUES (?,?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, resena.getTexto());
			ps.setLong(2, resena.getLibros_id());
			return ps;
		}, keyHolder);

		resena.setId(keyHolder.getKey().intValue());

		return resena;
	}
}
