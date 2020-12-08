package actividad2.accesodatos;

public interface Dao<T> {
	Iterable<T> obtenerTodos();
	T obtenerPorId(Long id);
	
	void crear(T objeto);
	void modificar(T objeto);
	void eliminar(Long id);
}
