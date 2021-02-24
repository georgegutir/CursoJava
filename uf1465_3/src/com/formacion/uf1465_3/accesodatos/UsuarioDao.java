package com.formacion.uf1465_3.accesodatos;

import com.formacion.uf1465_3.entidades.Usuario;

public interface UsuarioDao extends Dao<Usuario>{
	default Usuario obtenerPorUsuario(String usuario) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
}
