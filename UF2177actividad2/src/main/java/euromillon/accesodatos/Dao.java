package euromillon.accesodatos;

public interface Dao<T> {
	Iterable<T> obtenerTodos();
	T obtenerPorId(Long id);

	T agregar(T objeto);
	void borrar(Long id);
}
