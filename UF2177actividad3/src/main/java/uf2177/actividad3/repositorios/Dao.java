package uf2177.actividad3.repositorios;

public interface Dao<T> {
	Iterable<T> obtenerTodos();
	T obtenerPorId(long id);
	T obtenerPorIdConResenas(long id);
}
