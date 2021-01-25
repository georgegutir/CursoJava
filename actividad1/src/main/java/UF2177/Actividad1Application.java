package UF2177;

import java.math.BigDecimal;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import UF2177.entidades.Medicamentos;
import UF2177.repositorios.Dao;

@SpringBootApplication
public class Actividad1Application {
	
	// opciones del menú
	static final protected String OP_ALTAS = "1";
	static final protected String OP_BAJAS = "2";
	static final protected String OP_CONSULTAS = "3";
	static final protected String OP_SALIR = "s";
					
	// Variables globales
	static private Scanner sc = null;
	static private String opcion = "";

	public static void main(String[] args) {
		SpringApplication.run(Actividad1Application.class, args);
		System.out.println("hola");
	}
	
	@Autowired
	private Dao<Medicamentos> dao;
	
	public void run(String... args) throws Exception {
		boolean salida = true;
		sc = new Scanner(System.in);

		try {
			do {
				pintarMenu("medicamento");
				opcion = sc.nextLine();
				switch (opcion) {
				case OP_ALTAS:
					crear();
					break;
				case OP_BAJAS:
					eliminar();
					break;
				case OP_CONSULTAS:
					consultar();
					break;
				case OP_SALIR:
					salida = false;
					System.out.println("************FIN DEL PROGRAMA*************");
					break;
				default:
					System.out.println("Introduzca una opción válida:");
					break;
				}
			} while (salida);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		sc.close();
		
	}

	private void consultar() {
		System.out.println("*********LISTADO  DE  MEDICAMENTOS*********");

		for(Medicamentos medicamento: dao.obtenerTodos()) {
			System.out.println(medicamento);
		}	
	}

	private void eliminar() {
		boolean isError = true;
		
		consultar();
		
		do {
			try {
				System.out.println("Introduce el nº de referencia del medicamento que quieres eliminar:");
				Long id = Long.parseLong(sc.nextLine());
				if (dao.obtenerPorId(id) == null) {
					System.out.println("No se encuentra el medicamento en la base de datos");
				} else {
					dao.borrar(id);
					System.out.println("Medicamento eliminado");
					isError = false;
				}
			} catch (NumberFormatException e) {
				System.out.println("Debe introducir un numero");
	
			} catch (Exception e) {
				System.out.println("Ha ocurrido un ERROR");
			}
		}while (isError);
	}

	private void crear() {
		String nombre;
		BigDecimal precio = new BigDecimal(0);
		boolean isError = true;
		
		System.out.println("Introduce el nombre del medicamento:");
		nombre = sc.nextLine();

		do {
			try {
				System.out.println("Introducir el precio del medicamento:");
				precio = new BigDecimal(sc.nextLine());
				
				if (precio == null || precio.compareTo(BigDecimal.ZERO) < 0) {
					System.out.println("Debe ser mayor que 0");
					isError = true;
				} else {
					isError = false;
				}
				
			} catch (NumberFormatException e) {
				System.out.println("Debe introducir un número");
				isError = true;
			} catch (Exception e) {
				System.out.println("Error");
			}
		} while (isError);

		try {
			Medicamentos nuevo = new Medicamentos(null, nombre, precio);
			dao.agregar(nuevo);
			System.out.println("------------------------------------");
			System.out.println("Medicamento guardado");
			System.out.println("------------------------------------");
		} catch (Exception e) {
			System.out.println("Error al crear el nuevo libro");
		}
		
	}

	private void pintarMenu(final String nombre) {
		System.out.println("****************FARMACIA******************");
		System.out.println("******************************************");
		System.out.println(" " + OP_ALTAS + ".- Dar de alta nuevo " + nombre);
		System.out.println(" " + OP_BAJAS + ".- Eliminar un " + nombre);
		System.out.println(" " + OP_CONSULTAS + ".- Consultar listado de " + nombre);
		System.out.println(" " + OP_SALIR + " - Salir");
		System.out.println("******************************************");
		System.out.println("Escoja una opción:");
		
	}

}
