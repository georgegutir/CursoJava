package libreria.modelos;

import java.math.BigDecimal;

public class Libro {
	
	static final protected String AUTOR_DEFECTO = "Anónimo";
	static final protected String IMAGEN_DEFECTO = "img/imagen.jpg";

	private Long id;
	private String nombre;
	private BigDecimal precio;
	private Integer descuento;
	private String autor;
	private String urlImagen;
	
	private boolean correcto = true;

	private String errorId;
	private String errorNombre;
	private String errorPrecio;
	private String errorDescuento;
	private String errorAutor;
	private String errorUrlImagen;

	public Libro() {
		super();
		this.id = (long) 0;
		this.nombre = "Titulo Desconocido";
		this.precio = new BigDecimal(0);
		this.descuento = 0;
		this.autor = AUTOR_DEFECTO;
		this.urlImagen = IMAGEN_DEFECTO;
	}
	
	public Libro(Long id, String nombre, BigDecimal precio, Integer descuento, String autor, String urlImagen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.descuento = descuento;
		this.autor = autor;
		this.urlImagen = urlImagen;
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
		if (nombre == null || nombre.trim().length() < 3 || nombre.trim().length() > 150) {
			setErrorNombre("Debe tener al menos 3 letras y menos de 150");
		}
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Integer getDescuento() {
		return descuento;
	}

	public void setDescuento(Integer descuento) {
		this.descuento = descuento;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		setAutor(autor.trim().length() != 0 ? autor : AUTOR_DEFECTO);
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		setUrlImagen(urlImagen.trim().length() != 0 ? urlImagen : IMAGEN_DEFECTO);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
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
		Libro other = (Libro) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
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
		return "Libro [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descuento=" + descuento + ", autor="
				+ autor + ", urlImagen=" + urlImagen + "]";
	}

}
