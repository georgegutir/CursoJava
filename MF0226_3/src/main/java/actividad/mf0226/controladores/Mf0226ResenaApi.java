package actividad.mf0226.controladores;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import actividad.mf0226.entidades.Resena;
import actividad.mf0226.repositorios.ResenaDaoJdbcTemplate;

@RestController
@RequestMapping("/api/resenas")
public class Mf0226ResenaApi {
	private static final Logger LOGGER = Logger.getLogger(Mf0226ResenaApi.class.getName());
	
	@Autowired
	private ResenaDaoJdbcTemplate resenadao;
	
	@GetMapping
	public Iterable<Resena> get() {
		return resenadao.obtenerTodos();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Resena> getPorIdConResenas(@PathVariable int id) {
		Resena resena = resenadao.obtenerPorId(id);

		if (resena == null) {
			return new ResponseEntity<Resena>(HttpStatus.NOT_FOUND);
		}
		LOGGER.log(Level.INFO, resena.toString());
		return new ResponseEntity<Resena>(resena, HttpStatus.OK);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Resena post(@RequestBody Resena resena) {
		//LOGGER.log(Level.INFO, resena.toString());
		return resenadao.insertar(resena);
	}

	@PutMapping("{id}")
	public ResponseEntity<Resena> put(@PathVariable int id, @RequestBody Resena resena) {
		
		if (id != resena.getCodigo()) {
			LOGGER.log(Level.INFO, "resena id " + id + "!= " + resena.toString());
			return new ResponseEntity<Resena>(HttpStatus.BAD_REQUEST);
		}
		LOGGER.log(Level.INFO, resena.toString());
		return new ResponseEntity<Resena>(resenadao.modificar(resena), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Resena> delete(@PathVariable int id) {
		try {
			resenadao.borrar(id);
			return new ResponseEntity<Resena>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<Resena>(HttpStatus.NOT_FOUND);
		}
	}

}
