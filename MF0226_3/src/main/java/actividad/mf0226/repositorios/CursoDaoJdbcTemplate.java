package actividad.mf0226.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import actividad.mf0226.entidades.Curso;

@Repository
public class CursoDaoJdbcTemplate implements Dao<Curso> {

	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public Iterable<Curso> obtenerTodos() {
		return jdbc.query("SELECT c.codigo, c.nombre, c.identificador, c.nHoras, CONCAT(p.nombre,' ',p.apellidos) "
				+ "FROM curso AS c JOIN profesor AS p ON p.codigo = c.profesor_codigo",
				(rs, rowNum) -> new Curso(rs.getInt("c.codigo"), rs.getString("c.nombre"),
						rs.getString("c.identificador"), rs.getInt("c.nHoras"),
						rs.getString("CONCAT(p.nombre,' ',p.apellidos)")));
	}

	@Override
	public Curso obtenerPorId(int id) {
		return jdbc.queryForObject("SELECT c.codigo, c.nombre, c.identificador, r.resenas, c.nHoras "
				+ "FROM curso c inner join resena r on c.codigo = r.curso_codigo WHERE c.codigo = ?", new BeanPropertyRowMapper<Curso>(Curso.class), id);
	}

}