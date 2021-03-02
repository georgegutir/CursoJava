package com.ipartek.formacion.uf1466Actividad1.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.ipartek.formacion.uf1466Actividad1.entidades.Cliente;

public class ClienteDaoJdbc {
	private String url, usuario, password;

	private static final ClienteDaoJdbc INSTANCIA = new ClienteDaoJdbc();

	private static final String SQL_SELECT = "SELECT * FROM cliente";

	private ClienteDaoJdbc() {
		try {
			Properties props = new Properties();
			props.load(getClass().getClassLoader().getResourceAsStream("jdbc.properties"));

			Class.forName(props.getProperty("jdbc.driver"));

			url = props.getProperty("jdbc.url");
			usuario = props.getProperty("jdbc.usuario");
			password = props.getProperty("jdbc.password");

		} catch (Exception e) {
			throw new AccesoDatosException("No se ha podido leer el fichero de configuración jdbc.properties", e);
		}
	}

	public static ClienteDaoJdbc getInstancia() {
		return INSTANCIA;
	}

	private Connection getConexion() {
		try {
			return DriverManager.getConnection(url, usuario, password);
		} catch (Exception e) {
			throw new AccesoDatosException("Fallo de conexión", e);
		}
	}

	public Iterable<Cliente> obtenerTodos() {
		try (Connection con = getConexion();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(SQL_SELECT)) {
			ArrayList<Cliente> clientes = new ArrayList<>();
			Cliente cliente;

			while (rs.next()) {
				cliente = new Cliente(rs.getLong("codigo"), rs.getString("nombre"), rs.getString("email"), rs.getInt("telefono"), 
						rs.getString("direccion"), rs.getString("poblacion"), rs.getInt("codigopostal"), rs.getString("identificador"), 
						rs.getBoolean("activo"));

				clientes.add(cliente);
			}

			return clientes;
		} catch (Exception e) {
			throw new AccesoDatosException("Error al obtener los clientes", e);
		}
	}
	
}
