package com.ipartek.formacion.ejemplofinal.logicanegocio;

import com.ipartek.formacion.ejemplofinal.accesodatos.DaoFabrica;
import com.ipartek.formacion.ejemplofinal.accesodatos.DaoUsuario;
import com.ipartek.formacion.ejemplofinal.entidades.Usuario;

/**
 * La implementación de los mñetodos de UsuarioNegocio
 * 
 * @author Jorge Gutierrez
 * @version 1.0
 */
public class UsuarioNegocioImpl implements UsuarioNegocio {

	private DaoUsuario dao = DaoFabrica.getDaoUsuario();

	/**
	 * Llamada a validar los datos introducidos a ver si existe dicho usuario
	 * @param usuario
	 * @return boolean
	 */
	@Override
	public boolean validarUsuario(Usuario usuario) {
		Usuario usuarioBdd = dao.obtenerPorEmail(usuario.getEmail());

		if(usuarioBdd != null && usuario.getPassword().equals(usuarioBdd.getPassword())) {
			usuario.setId(usuarioBdd.getId());
			usuario.setCliente(usuarioBdd.getCliente());

			return true;
		} else {
			return false;
		}
	}

}