package spring.springdatajpaunoavarios.repositorios;

public interface Dao<T> {
	Iterable<T> obtenerTodos();
	T obtenerPorId(Long id);
}