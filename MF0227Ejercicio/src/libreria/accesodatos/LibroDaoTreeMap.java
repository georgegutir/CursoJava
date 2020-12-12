package libreria.accesodatos;

import java.math.BigDecimal;
import java.util.TreeMap;

import libreria.modelos.Libro;

public class LibroDaoTreeMap implements Dao<Libro> {

	private static TreeMap<Long, Libro> libros = new TreeMap<>();

	static {
		libros.put(1L, new Libro(1L, "Los futbolísimos. El misterio del jugador número 13", new BigDecimal(11.35), 0,
				"Roberto Santiago", "img/futbol1.jpg"));
		libros.put(2L, new Libro(2L, "Los futbolísimos. El misterio del obelisco mágico", new BigDecimal(11.35), 10,
				"Roberto Santiago", "img/futbol2.jpg"));
		libros.put(3L, new Libro(3L, "Los futbolísimos. El misterio del día de los inocentes", new BigDecimal(11.35),
				20, "Roberto Santiago", "img/futbol3.jpg"));
		libros.put(4L, new Libro(4L, "La caída de los gigantes", new BigDecimal(23.65), 30, "Ken Follett",
				"img/gigantes.jpg"));
		libros.put(5L,
				new Libro(5L, "El invierno del mundo", new BigDecimal(23.65), 10, "Ken Follett", "img/invierno.jpg"));
		libros.put(6L, new Libro(6L, "El umbral de la eternidad", new BigDecimal(23.65), 0, "Ken Follett",
				"img/eternidad.jpg"));
		libros.put(7L, new Libro(7L, "El corazón de las tinieblas", new BigDecimal(15.20), 15, "Joseph Conrad",
				"img/tinieblas.jpg"));
		libros.put(8L, new Libro(8L, "1984", new BigDecimal(9.45), 0, "George Orwell", "img/1984.jpg"));
	}

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

	@Override
	public void modificar(Libro libro) {
		libros.put(libro.getId(), libro);
	}

	@Override
	public void eliminar(Long id) {
		libros.remove(id);
	}
	
	public int ContarLibros () {
		return libros.size();
	}

}
