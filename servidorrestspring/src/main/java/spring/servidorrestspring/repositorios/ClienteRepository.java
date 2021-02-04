package spring.servidorrestspring.repositorios;

import org.springframework.data.repository.CrudRepository;

import spring.servidorrestspring.entidades.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	
}
