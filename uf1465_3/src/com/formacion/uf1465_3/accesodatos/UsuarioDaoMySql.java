package com.formacion.uf1465_3.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.formacion.uf1465_3.entidades.Usuario;

public class UsuarioDaoMySql implements UsuarioDao{
	private static final String SQL_SELECT = "SELECT * FROM usuarios WHERE usuario = ?";
	private DataSource dataSource = null;

	public UsuarioDaoMySql() {
		try {
			InitialContext initCtx=new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			dataSource = (DataSource)envCtx.lookup("jdbc/uf1465_3");
		} catch (NamingException e) {
			throw new AccesoDatosException("No se ha encontrado el JNDI de usuarioservlets", e);
		}
	}
/**
	@Override
	public Iterable<Usuario> obtenerTodos() {
		try (Connection con = dataSource.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(SQL_SELECT)) {
			ArrayList<Usuario> usuarios = new ArrayList<>();
			Usuario usuario;

			while(rs.next()) {
				usuario = new Usuario(rs.getLong("id"), rs.getString("usuario"), rs.getString("password"));

				usuarios.add(usuario);
			}

			return usuarios;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido obtener todos los registros de usuarios");
		} catch (Exception e) {
			throw new AccesoDatosException("ERROR NO ESPERADO: No se han podido obtener todos los registros de usuarios");
		}
	}
**/
	@Override
	public Usuario obtenerPorUsuario(String usuario) {
		try (Connection con = dataSource.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT);) {

			pst.setString(1, usuario);
			ResultSet rs = pst.executeQuery();
			
			Usuario user = null;

			if (rs.next()) {
				user = new Usuario(rs.getLong("id"), rs.getString("usuario"), rs.getString("password"));
			}

			return user;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el usuario " + usuario);
		} catch (Exception e) {
			throw new AccesoDatosException(
					"ERROR NO ESPERADO: No se ha podido obtener el usuario " + usuario);
		}
	}

}
