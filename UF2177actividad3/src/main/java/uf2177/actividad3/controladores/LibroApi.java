package uf2177.actividad3.controladores;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uf2177.actividad3.entidades.Libro;
import uf2177.actividad3.repositorios.LibroDaoJdbcTemplate;

@RestController
@RequestMapping("/api/libros")
public class LibroApi {
	
	private static final Logger LOGGER = Logger.getLogger(LibroApi.class.getName());
	
	@Autowired
	private LibroDaoJdbcTemplate dao;

	@GetMapping
	public Iterable<Libro> get() {
		LOGGER.log(Level.INFO, "GET: Lista de libros ");
		return dao.obtenerTodos();
	}

}
