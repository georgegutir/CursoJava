package uf2177.actividad3.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	@Autowired
	private ResenaDaoJdbcTemplate dao;

	//@GetMapping("{id}")
	//public ResponseEntity<Resena> getporId(@PathVariable long id) {
	//	Resena resena = dao.obtenerPorId(id);
	//	if (resena == null) {
	//		return new ResponseEntity<Resena>(HttpStatus.NOT_FOUND);
	//	}
	//	return new ResponseEntity<Resena>(resena, HttpStatus.OK);
	//}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Resena post(@RequestBody Resena resena) {
		return dao.insertar(resena);
	}
}
