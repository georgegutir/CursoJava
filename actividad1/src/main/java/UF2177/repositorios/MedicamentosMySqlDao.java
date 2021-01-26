package UF2177.repositorios;

import java.sql.PreparedStatement;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import UF2177.entidades.Medicamentos;

@Repository
public class MedicamentosMySqlDao implements Dao<Medicamentos>{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Iterable<Medicamentos> obtenerTodos() {
		return jdbcTemplate.query("SELECT * FROM medicamentos", new BeanPropertyRowMapper<Medicamentos>(Medicamentos.class));
	}

	@Override
	public Medicamentos obtenerPorId(Long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM medicamentos WHERE id = ?",
				new BeanPropertyRowMapper<Medicamentos>(Medicamentos.class), new Object[] { id });
	}

	@Override
	public Medicamentos agregar(Medicamentos medicamento) {
		
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO medicamentos (nombre, precio) VALUES (?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, medicamento.getNombre());
			ps.setBigDecimal(2, medicamento.getPrecio());
			return ps;
		}, keyHolder);

		return medicamento;
	}

	@Override
	public void borrar(Long id) {
		jdbcTemplate.update("DELETE FROM medicamentos WHERE id = ?", new Object[] { id });
	}


}
