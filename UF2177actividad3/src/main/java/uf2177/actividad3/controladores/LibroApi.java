package uf2177.actividad3.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uf2177.actividad3.entidades.Libro;
import uf2177.actividad3.repositorios.LibroDaoJdbcTemplate;

@RestController
@RequestMapping("/api/libros")
public class LibroApi {
	@Autowired
	private LibroDaoJdbcTemplate dao;

	@GetMapping
	public Iterable<Libro> get() {
		return dao.obtenerTodos();
	}

}
