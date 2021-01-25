package UF2177.repositorios;

public interface Dao<T> {
	Iterable<T> obtenerTodos();
	T obtenerPorId(Long id);

	T agregar(T objeto);
	void borrar(Long id);

}
