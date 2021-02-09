package uf2177.actividad3.repositorios;

import uf2177.actividad3.entidades.Resena;

public interface ResenaDao<T> extends Dao<Resena> {
	Iterable<T> obtenerResenaPorId(int id);
	Resena insertar(T t);
}
