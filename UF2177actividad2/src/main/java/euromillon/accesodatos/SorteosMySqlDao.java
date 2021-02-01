package euromillon.accesodatos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import euromillon.modelo.Sorteos;

@Repository
public class SorteosMySqlDao implements Dao<Sorteos>{
	private String url, usuario, password;
	
	private static final SorteosMySqlDao INSTANCIA = new SorteosMySqlDao();
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Iterable<Sorteos> obtenerTodos() {
		return jdbcTemplate.query("SELECT * FROM sorteos", new BeanPropertyRowMapper<Sorteos>(Sorteos.class));
	}

	@Override
	public Sorteos obtenerPorId(Long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM sorteos WHERE id = ?",
				new BeanPropertyRowMapper<Sorteos>(Sorteos.class), new Object[] { id });
	}

	@Override
	public Sorteos agregar(Sorteos sorteo) {
		jdbcTemplate.update("INSERT INTO sorteos (num1, num2, num3, num4, num5, star1, star2, fechasorteo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
				new Object[] { sorteo.getNum1(), sorteo.getNum2(), sorteo.getNum3(), sorteo.getNum4(), sorteo.getNum5(), sorteo.getStar1(), sorteo.getStar2(), sorteo.getFechasorteo() });

		// TODO: devolver el objeto insertado incluyendo el ID nuevo autogenerado por la
		// base de datos
		return null;
	}

	@Override
	public void borrar(Long id) {
		jdbcTemplate.update("DELETE FROM dorteos WHERE id = ?", new Object[] { id });	
	}

	public static SorteosMySqlDao getInstancia() {
		return INSTANCIA;
	}
	
}
