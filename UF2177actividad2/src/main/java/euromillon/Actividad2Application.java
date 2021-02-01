package euromillon;

import java.util.Calendar;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import euromillon.accesodatos.Dao;
import euromillon.modelo.Sorteos;

@SpringBootApplication
public class Actividad2Application {
	
		// opciones del menú
		static final protected String OP_ALTAS = "1";
		static final protected String OP_CONSULTAS = "2";
		static final protected String OP_SALIR = "s";

		// Variables globales
		static private Scanner sc = null;
		static private String opcion = "";
		
		static final private int NUM = 5;
		static final private int STARS = 2;

		static final private int NUM_MIN = 1;
		static final private int NUM_MAX = 50;

		static final private int NUM_MAX_STAR = 12;

		public static void main(String[] args) {
			SpringApplication.run(Actividad2Application.class, args);
			System.out.println("hola");
		}

		@Autowired
		private Dao<Sorteos> dao;

		public void run(String... args) throws Exception {
			boolean salida = true;
			sc = new Scanner(System.in);

			try {
				do {
					pintarMenu("sorteo");
					opcion = sc.nextLine();
					switch (opcion) {
					case OP_ALTAS:
						crear();
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
			System.out.println("************LISTADO  DE  SORTEOS************");

			for(Sorteos sorteo: dao.obtenerTodos()) {
				System.out.println(sorteo);
			}	
		}

		
		private void crear() {
			int[] numeros = new int[NUM];
			int[] stars = new int[STARS];

			Calendar fechasorteo = Calendar.getInstance();
			String numeroString = null;
			boolean isError = true;
			
			System.out.println("Sorteo euromillón del" + fechasorteo + ":");

			//TODO sorteo

			try {
				Sorteos sorteo = new Sorteos();
				dao.agregar(sorteo);
				System.out.println("------------------------------------");
				System.out.println("Sorteo guardado");
				System.out.println("------------------------------------");
			} catch (Exception e) {
				System.out.println("Error al crear el nuevo sorteo");
			}

		}

		private void pintarMenu(final String nombre) {
			System.out.println("****************EL EUROMILLÓN******************");
			System.out.println("***********************************************");
			System.out.println(" " + OP_ALTAS + ".- Dar de alta nuevo " + nombre);
			System.out.println(" " + OP_CONSULTAS + ".- Consultar listado de " + nombre);
			System.out.println(" " + OP_SALIR + " - Salir");
			System.out.println("***********************************************");
			System.out.println("Escoja una opción:");

		}

}
