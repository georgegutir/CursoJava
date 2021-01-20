package ferreteria.modelos;

import java.io.Serializable;
import java.math.BigDecimal;

public class Producto implements Serializable {

	private static final long serialVersionUID = 5452816664057554386L;
	
	private Long id;
	private String nombre;
	private String urlImagen;
	private BigDecimal precio;
	private Integer descuento;
	private Integer cantidad;
	
	private boolean correcto = true;

	private String errorId;
	private String errorNombre;
	private String errorUrlImagen;
	private String errorPrecio;
	private String errorDescuento;
	private String errorCantidad;
	
	public Producto(Long id, String nombre, String urlImagen, BigDecimal precio,
			Integer descuento, Integer cantidad) {
		setId(id);
		setNombre(nombre);
		setUrlImagen(urlImagen);
		setPrecio(precio);
		setDescuento(descuento);
		setCantidad(cantidad);
	}

	public Producto(String id, String nombre, String urlImagen, String precio, 
			String descuento, String cantidad) {

		//this(id.trim().length() != 0 ? Long.parseLong(id) : null, nombre, urlImagen, 
		//		new BigDecimal(precio), Integer.parseInt(descuento), Integer.parseInt(cantidad));
		setId(id);
		setNombre(nombre);
		setUrlImagen(urlImagen);
		setPrecio(precio);
		setDescuento(descuento);
		setCantidad(cantidad);
	}
	
	private void setCantidad(String cantidad) {
		try {
			setCantidad(Integer.parseInt(cantidad));
		} catch (Exception e) {
			setErrorCantidad("La cantidad debe ser un número");
		}
	}

	private void setDescuento(String descuento) {
		try {
			setDescuento(Integer.parseInt(descuento));
		} catch (NumberFormatException e) {
			setErrorDescuento("El descuento debe ser un número entero");
		}
	}

	private void setPrecio(String precio) {
		try {
			setPrecio(new BigDecimal(precio));
		} catch (Exception e) {
			setErrorPrecio("El precio no tiene un formato correcto");
		}
	}

	private void setId(String id) {
		try {
			setId(id.trim().length() != 0 ? Long.parseLong(id) : null);
		} catch (NumberFormatException e) {
			setErrorId("El id debe ser numérico");
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		if (id != null && id <= 0) {
			setErrorId("No se admiten ids inferiores o iguales a 0");
		}
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null || nombre.trim().length() < 3 || !nombre.matches("\\p{Lu}\\p{Ll}{2}[\\p{Ll} ]*")) {
			setErrorNombre("Debe introducir un nombre con solo letras y mayúscula la primera. Mínimo 3 caracteres");
		}
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
		// precio < 10 -----> precio.compareTo(new BigDecimal("10")) < 0
		// precio >= 100 ---> precio.compareTo(new BigDecimal("100")) >= 0
		// precio == 5 -----> precio.compareTo(new BigDecimal("5")) == 0
		if (precio == null || precio.compareTo(BigDecimal.ZERO) < 0) {
			setErrorPrecio("Debe rellenarse y ser mayor que 0");
		}
		this.precio = precio;
	}

	public Integer getDescuento() {
		return descuento;
	}

	public void setDescuento(Integer descuento) {
		if (descuento != null && (descuento < 0 || descuento > 100)) {
			setErrorDescuento("El descuento debe estar comprendido entre 0 y 100");
		}
		this.descuento = descuento;
	}
	
	public BigDecimal getPrecioConDescuento() {
		
		if(descuento == null || descuento == 0) {
			return precio;
		}

		if(descuento == 100) {
			return BigDecimal.ZERO;
		}
		//return precio - (precio * (descuento / 100));
		return precio.subtract(precio.multiply(new BigDecimal(descuento).divide(new BigDecimal(100))));
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		if(cantidad == null || cantidad < 0) {
			setCantidad("La cantidad debe ser mayor o igual a cero. Es obligatoria");
		}
		this.cantidad = cantidad;
	}
	
	public boolean isCorrecto() {
		return correcto;
	}

	public void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}

	public String getErrorId() {
		return errorId;
	}

	public void setErrorId(String errorId) {
		correcto = false;
		this.errorId = errorId;
	}

	public String getErrorNombre() {
		return errorNombre;
	}

	public void setErrorNombre(String errorNombre) {
		correcto = false;
		this.errorNombre = errorNombre;
	}

	public String getErrorUrlImagen() {
		return errorUrlImagen;
	}

	public void setErrorUrlImagen(String errorUrlImagen) {
		correcto = false;
		this.errorUrlImagen = errorUrlImagen;
	}

	public String getErrorPrecio() {
		return errorPrecio;
	}

	public void setErrorPrecio(String errorPrecio) {
		correcto = false;
		this.errorPrecio = errorPrecio;
	}

	public String getErrorDescuento() {
		return errorDescuento;
	}

	public void setErrorDescuento(String errorDescuento) {
		correcto = false;
		this.errorDescuento = errorDescuento;
	}

	public String getErrorCantidad() {
		return errorCantidad;
	}

	public void setErrorCantidad(String errorCantidad) {
		correcto = false;
		this.errorCantidad = errorCantidad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cantidad == null) ? 0 : cantidad.hashCode());
		result = prime * result + ((descuento == null) ? 0 : descuento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
		result = prime * result + ((urlImagen == null) ? 0 : urlImagen.hashCode());
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
		if (descuento == null) {
			if (other.descuento != null)
				return false;
		} else if (!descuento.equals(other.descuento))
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
		return "Producto [id=" + id + ", nombre=" + nombre + ", urlImagen=" + urlImagen + ", precio=" + precio
				+ ", descuento=" + descuento + ", cantidad=" + cantidad + ", correcto=" + correcto + ", errorId="
				+ errorId + ", errorNombre=" + errorNombre + ", errorUrlImagen=" + errorUrlImagen + ", errorPrecio="
				+ errorPrecio + ", errorDescuento=" + errorDescuento + ", errorCantidad=" + errorCantidad + "]";
	}

}
