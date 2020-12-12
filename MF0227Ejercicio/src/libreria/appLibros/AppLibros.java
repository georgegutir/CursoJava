package libreria.appLibros;

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
					//crear();
					break;
				case OP_ELIMINAR:
					//eliminar();
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

		System.out.println("*************LIBRERÍA***************");
		System.out.println("************************************");
		System.out.println(" " + OP_LISTAR + ".- Listar todos los " + nombre);
		System.out.println(" " + OP_CREAR + ".- Crear un " + nombre);
		System.out.println(" " + OP_ELIMINAR + ".- Dar de baja un " + nombre);
		System.out.println(" " + OP_SALIR + " - Salir");
		System.out.println("************************************");
		System.out.println("Escoja una opción:");
	}
	
	/**
	 * Listar todos los libros
	 */
	public static void listar() {
		
		System.out.println("*********LISTADO  DE  LIBROS*********");

		for (Libro libro : dao.obtenerTodos()) {
			System.out.printf("%2s - %-80s - Precio: %.2f€ %s\n", + libro.getId(), libro.getNombre(), 
					libro.getPrecio(), (libro.getDescuento() > 0 ? "(Descuento: " + libro.getDescuento() + "%)" : ""));
		}

		System.out.println("------------------------------------");
		System.out.printf("En la librería hay %s libros en total\n", dao.ContarLibros());
		System.out.println("------------------------------------");
	}
	
	public static void crear() throws Exception {
		Libro libro = new Libro();
		boolean isError = true;
		do {
			try {
				System.out.println("Introduce el nombre del libro");
				libro.setNombre(sc.nextLine());

				isError = false;

			} catch (NumberFormatException e) {
				System.out.println("Debe introducir un n�");
				sc.nextLine();
			} catch (Exception e) {
				throw new Exception("Error");
			}
		} while (isError);
		
	}


}
