package filmoteca.accesodatos;

import java.math.BigDecimal;
import java.util.TreeMap;

import filmoteca.modelos.Producto;

public class ProductoDaoTreeMap implements Dao<Producto>{
	
	private static TreeMap<Long, Producto> productos = new TreeMap<>();
	
	static {
		productos.put(1L, new Producto(1L, "El padrino", "drama", "mafia italiana en NY", "padrino.jpg", new BigDecimal("4.95"), 20));
		for (Long id = 2L; id <= 12L; id++) {
			productos.put(id, new Producto(id, "Producto" + id, "Genero" + id, "Descripción" + id, "foto" + id + ".jpg", new BigDecimal(5 * id), id.intValue()));
		}
	}
	
	//SINGLETON
	
			// Ponemos privado el constructor por defecto para que nadie pueda crear instancias de esta clase de forma libre
			// Con esto evitamos la posibilidad de que nadie haga new de esta clase (salvo esta clase en sí misma)
			private ProductoDaoTreeMap() {}
			
			// Creamos el único objeto que va a existir de este tipo
			private static ProductoDaoTreeMap INSTANCIA = new ProductoDaoTreeMap();
			
			// Creamos un método público que de acceso a la única instancia disponible
			// Desde otras clases deberemos hacer 
			// ProductoDaoTreeMap dao = ProductoDaoTreeMap.getInstancia();
			// o mejor
			// Dao<Producto> dao = ProductoDaoTreeMap.getInstancia();
			public static ProductoDaoTreeMap getInstancia() { 
				return INSTANCIA;
			}
			
			//FIN SINGLETON
		
	
	@Override
	public Iterable<Producto> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto obtenerPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crear(Producto objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(Producto objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

}
