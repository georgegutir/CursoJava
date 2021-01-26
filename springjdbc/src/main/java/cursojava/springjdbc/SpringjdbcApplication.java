package cursojava.springjdbc;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DataAccessException;

import cursojava.springjdbc.entidades.Cliente;
import cursojava.springjdbc.repositorios.Dao;

@SpringBootApplication
public class SpringjdbcApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringjdbcApplication.class, args);
	}

	@Autowired
	private Dao<Cliente> dao;
	
	@Override
	public void run(String... args) throws Exception {
		try {
			System.out.println(dao.agregar(new Cliente(null, "Nuevoll", "Nuevez Novisimez", "13243545Z", LocalDate.now())));

			dao.modificar(new Cliente(5L, "Juan", "Juanes", "87654321A", LocalDate.now()));

			dao.borrar(6L);

			for(Cliente cliente: dao.obtenerTodos()) {
				System.out.println(cliente);
			}

			System.out.println(dao.obtenerPorId(1L));
		} catch (DataAccessException e) {
			System.out.println("Error de acceso a datos");
			e.printStackTrace();
		}
		
	}

}
