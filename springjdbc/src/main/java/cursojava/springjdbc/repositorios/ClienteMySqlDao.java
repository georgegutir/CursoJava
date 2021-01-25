package cursojava.springjdbc.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cursojava.springjdbc.entidades.Cliente;

@Repository
public class ClienteMySqlDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Iterable<Cliente> obtenerTodos() {
		return jdbcTemplate.query("SELECT * FROM clientes", new BeanPropertyRowMapper<Cliente>(Cliente.class));
	}

	public Cliente obtenerPorId(Long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM clientes WHERE id = ?",
				new BeanPropertyRowMapper<Cliente>(Cliente.class), new Object[] { id });
	}

	public Cliente agregar(Cliente cliente) {
		jdbcTemplate.update("INSERT INTO clientes (nombre, apellidos, cif, fecha_nacimiento) VALUES (?, ?, ?, ?)",
				new Object[] { cliente.getNombre(), cliente.getApellidos(), cliente.getCif(),
						cliente.getFechaNacimiento() });

		// TODO: devolver el objeto insertado incluyendo el ID nuevo autogenerado por la
		// base de datos
		return cliente;
	}

	public Cliente modificar(Cliente cliente) {
		jdbcTemplate.update("UPDATE clientes SET nombre = ?, apellidos = ?, cif = ?, fecha_nacimiento = ? WHERE id = ?",
				new Object[] { cliente.getNombre(), cliente.getApellidos(), cliente.getCif(),
						cliente.getFechaNacimiento(), cliente.getId() });
		return cliente;
	}

	public void borrar(Long id) {
		jdbcTemplate.update("DELETE FROM clientes WHERE id = ?", new Object[] { id });
	}


}
