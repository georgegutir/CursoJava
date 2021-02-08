package spring.servidorrestspring.repositorios;

public interface Dao<T> {
	Iterable<T> obtenerTodos();
	T obtenerPorId(Long codigo);

	T insertar(T t);
	T modificar(T t);
	void borrar(Long id);
}