package libreria.appLibros;

import java.math.BigDecimal;
import java.util.Scanner;

import libreria.accesodatos.LibroDaoTreeMap;
import libreria.modelos.Libro;

/**
 * Primera parte del ejercicio para realizar el programa en java en consola. <br>
 * Clase principal para ejecutar el main <br>
 * 
 * @author Jorge Gutiérrez
 */
public class AppLibros {
	
	// opciones del men�
		static final protected String OP_LISTAR = "1";
		static final protected String OP_CREAR = "2";
		static final protected String OP_ELIMINAR = "3";
		static final protected String OP_SALIR = "s";
		
	// Variables globales
		static private Scanner sc = null;
		static private String opcion = "";
		static private LibroDaoTreeMap dao = LibroDaoTreeMap.getInstancia();
		static final protected String AUTOR_DEFECTO = "Anónimo";
		static final protected String IMAGEN_DEFECTO = "img/imagen.jpg";

	public static void main(String[] args) {
		
		boolean salida = true;
		sc = new Scanner(System.in);

		try {
			do {
				pintarMenu("Libro");
				opcion = sc.nextLine();
				switch (opcion) {
				case OP_LISTAR:
					listar();
					break;
				case OP_CREAR:
					crear();
					break;
				case OP_ELIMINAR:
					eliminar();
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
	
	/**
	 * Se encarga de pintar las opciones del menu.
	 * @param nombrePojo nombre del recurso que se gestiona en esta App
	 */
	protected static void pintarMenu(final String nombre) {

		System.out.println("****************LIBRERÍA******************");
		System.out.println("******************************************");
		System.out.println(" " + OP_LISTAR + ".- Listar todos los " + nombre);
		System.out.println(" " + OP_CREAR + ".- Crear un " + nombre);
		System.out.println(" " + OP_ELIMINAR + ".- Dar de baja un " + nombre);
		System.out.println(" " + OP_SALIR + " - Salir");
		System.out.println("******************************************");
		System.out.println("Escoja una opción:");
	}
	
	/**
	 * Listar todos los libros
	 */
	public static void listar() {
		
		System.out.println("*********LISTADO  DE  LIBROS*********");

		for (Libro libro : dao.obtenerTodos()) {
			System.out.printf("%2s - %-70s - %-20s - Precio: %.2f€ %20s - %-20s\n", + libro.getId(), libro.getNombre(), libro.getAutor(), 
					libro.getPrecio(), (libro.getDescuento() > 0 ? "(Descuento: " + libro.getDescuento() + "%)" : ""), libro.getUrlImagen());
		}

		System.out.println("------------------------------------");
		System.out.printf("En la librería hay %s libros en total\n", dao.ContarLibros());
		System.out.println("------------------------------------");
	}
	
	/**
	 * Crear nuevo libro
	 */
	public static void crear() throws Exception {
		String nombre, autor, urlImagen;
		BigDecimal precio = new BigDecimal(0);
		Integer descuento = 0;
		boolean isError = true;
		
		do {
			System.out.println("Introduce el nombre del libro:");
			nombre = sc.nextLine();

			if (nombre.trim().length() < 3 || nombre.trim().length() > 150) {
				System.out.println("Debe tener más de 2 letras y menos de 150");
				isError = true;
			} else {
				isError = false;
			}

		} while (isError);

		do {
			try {
				System.out.println("Introducir el precio del libro:");
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

		do {
			try {
				System.out.println("Introducir descuento del libro:");
				descuento = Integer.parseInt(sc.nextLine());
				
				if (descuento != null && (descuento < 0 || descuento > 100)) {
					System.out.println("El descuento debe estar comprendido entre 0 y 100");
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
		
		System.out.println("Introducir el autor del libro (opcional):");
		autor = sc.nextLine();
		if (autor.isEmpty()) {
			autor = AUTOR_DEFECTO;
		}

		System.out.println("Introducir url de la imagen (opcional):");
		urlImagen = sc.nextLine();
		if (urlImagen.isEmpty()) {
			urlImagen = IMAGEN_DEFECTO;
		}

		try {

			Libro nuevo = new Libro(null, nombre, precio, descuento, autor, urlImagen);
			dao.crear(nuevo);
			System.out.println("------------------------------------");
			System.out.println("Libro guardado");
			System.out.println("------------------------------------");
		} catch (Exception e) {
			System.out.println("Error al crear el nuevo libro");
		}
	}
	
	/**
	 * Eliminar un libro ya creado libro
	 */
	public static void eliminar() {
		boolean isError = true;
		
		listar();
		
		do {
			try {
				System.out.println("Introduce el id del libro que quieres eliminar:");
				Long id = Long.parseLong(sc.nextLine());
				if (dao.obtenerPorId(id) == null) {
					System.out.println("No se encuentra el libro en la base de datos");
				} else {
					dao.eliminar(id);
					System.out.println("Libro eliminado");
					isError = false;
				}
			} catch (NumberFormatException e) {
				System.out.println("Debe introducir un numero");
	
			} catch (Exception e) {
				System.out.println("Ha ocurrido un ERROR");
			}
		}while (isError);
	}

}
