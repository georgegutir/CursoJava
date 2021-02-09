package actividad.mf0226.repositorios;

import java.sql.PreparedStatement;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import actividad.mf0226.entidades.Resena;

@Repository
public class ResenaDaoJdbcTemplate implements ResenaDao {

	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public Iterable<Resena> obtenerTodos() {
		return jdbc.query("SELECT * FROM resena", new BeanPropertyRowMapper<Resena>(Resena.class));
	}

	@Override
	public Resena obtenerPorId(int id) {
		return jdbc.queryForObject("SELECT * FROM resena WHERE curso_codigo = ?",
				new BeanPropertyRowMapper<Resena>(Resena.class), id);
	}

	@Override
	public Resena insertar(Resena resena) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbc.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO resena (resenas, alumno_codigo, curso_codigo) VALUES (?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, resena.getResenas());
			ps.setInt(2, resena.getAlumno_codigo());
			ps.setInt(3, resena.getCurso_codigo());
			return ps;
		}, keyHolder);

		resena.setCodigo(keyHolder.getKey().intValue());

		return resena;
	}

	@Override
	public Resena modificar(Resena r) {
		jdbc.update("UPDATE resena SET resenas = ?, alumno_codigo = ?, curso_codigo = ? WHERE codigo = ?", 
				r.getResenas(), r.getAlumno_codigo(), r.getCurso_codigo(), r.getCodigo());
		return r;
	}

	@Override
	public void borrar(int id) {
		jdbc.update("DELETE FROM resena WHERE codigo = ?", id);

	}

}