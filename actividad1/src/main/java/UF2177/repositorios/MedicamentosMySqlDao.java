package UF2177.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
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
		jdbcTemplate.update("INSERT INTO medicamentos (nombre, precio) VALUES (?, ?)",
				new Object[] { medicamento.getNombre(), medicamento.getPrecio() });

		// TODO: devolver el objeto insertado incluyendo el ID nuevo autogenerado por la
		// base de datos
		return medicamento;
	}

	@Override
	public void borrar(Long id) {
		jdbcTemplate.update("DELETE FROM medicamentos WHERE id = ?", new Object[] { id });
	}


}
