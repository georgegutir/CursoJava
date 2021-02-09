package uf2177.actividad3.controladores;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import uf2177.actividad3.entidades.Resena;
import uf2177.actividad3.repositorios.ResenaDaoJdbcTemplate;

@RestController
@RequestMapping("/api/resenas")
public class ResenaApi {
	
	private static final Logger LOGGER = Logger.getLogger(LibroApi.class.getName());
	
	@Autowired
	private ResenaDaoJdbcTemplate dao;
	
	@GetMapping("{id}")
	public Iterable<Resena> get(@PathVariable int id) {
		LOGGER.log(Level.INFO, "GET: " + id + "resenas");
		Iterable<Resena> resenas = dao.obtenerResenaPorId(id);
		
		return resenas;
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Resena post(@RequestBody Resena resena) {
		LOGGER.log(Level.INFO, "POST: Insertar resena " + resena.toString());
		return dao.insertar(resena);
	}
}
