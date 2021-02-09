package uf2177.actividad3.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("{id}/resenas")
	public ResponseEntity<Libro> getPorId(@PathVariable long id) {
		Libro libro = dao.obtenerPorIdConResenas(id);
		if (libro == null) {
			return new ResponseEntity<Libro>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Libro>(libro, HttpStatus.OK);
	}

}
