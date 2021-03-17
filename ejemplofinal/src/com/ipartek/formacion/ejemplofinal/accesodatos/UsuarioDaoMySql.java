package com.ipartek.formacion.ejemplofinal.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ipartek.formacion.ejemplofinal.entidades.Cliente;
import com.ipartek.formacion.ejemplofinal.entidades.Usuario;

/**
 * Implementa el acceso a DaoUsuario
 * 
 * @author Jorge Gutierrez
 * @version 1.0
 */
public class UsuarioDaoMySql implements DaoUsuario {

	private static final String SQL_EMAIL = "SELECT * FROM usuarios u LEFT JOIN clientes c ON u.clientes_id = c.id WHERE email = ?";

	/**
	 * Buscar en la bbdd y obtener al usuario a través del email introducido
	 * @param email
	 * @return usuario
	 */
	@Override
	public Usuario obtenerPorEmail(String email) {
		try (Connection con = Config.dataSource.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_EMAIL)) {
			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();

			Usuario usuario = null;
			Cliente cliente = null;

			if(rs.next()) {
				cliente = new Cliente(rs.getLong("c.id"), rs.getString("c.nombre"), rs.getString("c.apellidos"), rs.getString("c.cif"), rs.getDate("c.fecha_nacimiento").toLocalDate(), null);
				usuario = new Usuario(rs.getLong("u.id"), rs.getString("u.email"), rs.getString("u.password"), cliente);
			}

			return usuario;
		} catch (Exception e) {
			throw new AccesoDatosException("No ha podido obtener el usuario por su email: " + email, e);
		}
	}

}