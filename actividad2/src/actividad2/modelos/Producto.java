package actividad2.modelos;

import java.io.Serializable;
import java.math.BigDecimal;

public class Producto implements Serializable{
	
	private static final long serialVersionUID = 5452816664057554386L;
	
	private Long id;
	private String nombre;
	private String urlImagen;
	private BigDecimal precio;
	private Integer cantidad;
	
	public Producto(Long id, String nombre, String urlImagen, BigDecimal precio, Integer cantidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.urlImagen = urlImagen;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cantidad == null) ? 0 : cantidad.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((urlImagen == null) ? 0 : urlImagen.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (cantidad == null) {
			if (other.cantidad != null)
				return false;
		} else if (!cantidad.equals(other.cantidad))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		if (urlImagen == null) {
			if (other.urlImagen != null)
				return false;
		} else if (!urlImagen.equals(other.urlImagen))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", urlImagen=\" + urlImagen\r\n"
				+ "				+ \", precio=" + precio + ", cantidad=" + cantidad +"]";
	}

	public BigDecimal getTotalProducto() {
		return getPrecio().multiply(new BigDecimal(cantidad));
	}
	

}
