package com.ipartek.formacion.uf1466Actividad2.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.ipartek.formacion.uf1466Actividad2.entidades.Autor;
import com.ipartek.formacion.uf1466Actividad2.entidades.Libro;

public class LibroDaoJdbc implements LibroDao{
	private static final String SQL_SELECT = "SELECT l.id, l.titulo, l.isbn, a.id, a.nombre, a.apellidos FROM libros AS l\r\n"
			+ "LEFT JOIN autores AS a ON l.autores_id = a.id ";
	private static final String SQL_SELECT_ID = SQL_SELECT + "WHERE l.id = ?";
	private static final String SQL_SELECT_TITULO = SQL_SELECT + "WHERE l.titulo LIKE ?";
	private static final String SQL_SELECT_ISBN = SQL_SELECT + "WHERE l.isbn = ?";

	private String url;
	private String usuario;
	private String password;

	private static final LibroDaoJdbc INSTANCIA = new LibroDaoJdbc();


	private LibroDaoJdbc() {
		try {
			Properties props = new Properties();
			props.load(getClass().getClassLoader().getResourceAsStream("jdbc.properties"));

			Class.forName(props.getProperty("jdbc.driver"));

			url = props.getProperty("jdbc.url");
			usuario = props.getProperty("jdbc.usuario");
			password = props.getProperty("jdbc.password");

		} catch (Exception e) {
			throw new AccesoDatosException("No se ha podido leer el fichero jdbc.properties", e);
		}
	}

	public static LibroDaoJdbc getInstancia() {
		return INSTANCIA;
	}
	
	private Connection getConexion() {
		try {
			return DriverManager.getConnection(url, usuario, password);
		} catch (Exception e) {
			throw new AccesoDatosException("Fallo de conexión", e);
		}
	}
	
	@Override
	public Iterable<Libro> obtenerTodos() {
		try (Connection con = getConexion();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(SQL_SELECT)) {
			ArrayList<Libro> libros = new ArrayList<>();
			Libro libro;
			Autor autor;

			while (rs.next()) {
				autor = new Autor(rs.getLong("a.id"), rs.getString("a.nombre"), rs.getString("a.apellidos"));
				libro = new Libro(rs.getLong("l.id"), rs.getString("l.titulo"), rs.getString("l.isbn"), autor);

				libros.add(libro);
			}
			return libros;
		} catch (Exception e) {
			throw new AccesoDatosException("Error al obtener todos los libros", e);
		}
	}
	
	@Override
	public Libro obtenerPorId(Long id) {
		try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement(SQL_SELECT_ID);) {
			ps.setLong(1, id);

			try (ResultSet rs = ps.executeQuery()) {
				Libro libro = null;
				Autor autor;
				if (rs.next()) {
					libro = new Libro(rs.getLong("l.id"), rs.getString("l.titulo"), rs.getString("l.ISBN"), null);
					autor = new Autor(rs.getLong("a.id"), rs.getString("a.nombre"), rs.getString("a.apellidos"));

					libro.setAutor(autor);
				}
				return libro;
			}
		} catch (Exception e) {
			throw new AccesoDatosException("Error al obtener el libro", e);
		}
	}

	@Override
	public Libro obtenerPorISBN(String isbn) {
		try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement(SQL_SELECT_ISBN);) {

			ps.setString(1, isbn);

			try (ResultSet rs = ps.executeQuery()) {
				Libro libro = null;
				Autor autor = null;
				if (rs.next()) {

					libro = new Libro(rs.getLong("l.id"), rs.getString("l.titulo"), rs.getString("l.ISBN"), null);
					autor = new Autor(rs.getLong("a.id"), rs.getString("a.nombre"), rs.getString("a.apellidos"));

					libro.setAutor(autor);
				}
				return libro;
			}
		} catch (Exception e) {
			throw new AccesoDatosException("Error al obtener el registro de libro", e);
		}
	}
	
	@Override
	public Iterable<Libro> obtenerPorTitulo(String titulo) {
		try (Connection con = getConexion(); PreparedStatement ps = con.prepareStatement(SQL_SELECT_TITULO);) {

			ps.setString(1, "%" + titulo + "%");

			try (ResultSet rs = ps.executeQuery()) {
				ArrayList<Libro> librosArray = new ArrayList<>();
				Libro libro = null;
				Autor autor = null;

				while (rs.next()) {
					autor = new Autor(rs.getLong("a.id"), rs.getString("a.nombre"), rs.getString("a.apellidos"));
					libro = new Libro(rs.getLong("l.id"), rs.getString("l.titulo"), rs.getString("l.ISBN"), autor);

					librosArray.add(libro);
				}

				return librosArray;
			}
		} catch (Exception e) {
			throw new AccesoDatosException("Error al obtener libro", e);
		}
	}

}
