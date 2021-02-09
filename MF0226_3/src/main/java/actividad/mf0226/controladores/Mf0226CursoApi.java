package actividad.mf0226.controladores;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import actividad.mf0226.entidades.Curso;
import actividad.mf0226.repositorios.CursoDaoJdbcTemplate;

@RestController
//@RequestMapping("/api/cursos/*")
public class Mf0226CursoApi {
	private static final Logger LOGGER = Logger.getLogger(Mf0226CursoApi.class.getName());
	
	@Autowired
	private CursoDaoJdbcTemplate cursodao;

	@RequestMapping("/api/cursos")
	@GetMapping
	public Iterable<Curso> get() {
		return cursodao.obtenerTodos();
	}

	@RequestMapping("/api/cursos/{id}")
	@GetMapping("{id}")
	public ResponseEntity<Curso> obtenerPorId(@PathVariable int id) {
		Curso curso = cursodao.obtenerPorId(id);

		if (curso == null) {
			return new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);
		}
		LOGGER.log(Level.INFO, curso.toString());

		return new ResponseEntity<Curso>(curso, HttpStatus.OK);
	}

}