package spring.springdatajpaunoavarios.repositorios;

import spring.springdatajpaunoavarios.entidades.Categoria;

public interface CategoriaDao extends Dao<Categoria> {
	Categoria obtenerPorIdConProductos(Long id);
}
