package ferreteria.accesodatos;

import java.math.BigDecimal;
import java.util.TreeMap;

import org.apache.commons.lang3.SerializationUtils;

import ferreteria.modelos.Producto;

public class ProductoDaoTreeMap implements Dao<Producto> {
	
	private static TreeMap<Long, Producto> productos = new TreeMap<>();
	
	static {
		productos.put(1L, new Producto(1L, "Martillo", "img/martillo.jpg", new BigDecimal("9.95"), 20, 5));
		for (Long id = 2L; id <= 12L; id++) {
			productos.put(id, new Producto(id, "Producto" + id, "http://placeimg.com/640/480/nature?" + id, new BigDecimal(5 * id),  id.intValue(), id.intValue()));
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
		return productos.values();
	}

	@Override
	public Producto obtenerPorId(Long id) {
		return SerializationUtils.clone(productos.get(id));
	}

	@Override
	public void crear(Producto producto) {
		Long id = productos.size() == 0 ? 1L : productos.lastKey() + 1L; //La 'L' se refiere a que es un Long para poder tener más capacidad
		producto.setId(id);
		productos.put(id, producto);
	}

	@Override
	public void modificar(Producto producto) {
		productos.put(producto.getId(), producto);
	}

	@Override
	public void eliminar(Long id) {
		productos.remove(id);
	}

}
