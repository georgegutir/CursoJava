package actividad3.accesodatos;

import java.util.TreeMap;

import actividad3.modelos.Libro;

public class LibroDaoTreeMap implements Dao<Libro> {

	private static TreeMap<Long, Libro> libros = new TreeMap<>();

	// SINGLETON
	private LibroDaoTreeMap() {
	}

	private static LibroDaoTreeMap INSTANCIA = new LibroDaoTreeMap();

	public static LibroDaoTreeMap getInstancia() {
		return INSTANCIA;
	}

	// FIN SINGLETON

	@Override
	public Iterable<Libro> obtenerTodos() {
		return libros.values();
	}

	@Override
	public Libro obtenerPorId(Long id) {
		return libros.get(id);
	}

	@Override
	public void crear(Libro libro) {
		Long id = libros.size() == 0 ? 1L : libros.lastKey() + 1L;
		libro.setId(id);
		libros.put(id, libro);
	}

}
