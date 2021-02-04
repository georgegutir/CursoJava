package spring.springdatajpaunoavarios.repositorios;

import org.springframework.data.repository.CrudRepository;

import spring.springdatajpaunoavarios.entidades.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long> {

}