package com.ipartek.formacion.mf0223.accesodatos;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Configuración de la aplicacion con la bbdd
 * 
 * @author Jorge Gutierrez
 * @version 1.0
 */
class Config {
	private static final String JDBC_MF0223 = "jdbc/mf0223";

	private Config() {}

	static final DataSource dataSource;

	static {
		try {
			InitialContext initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			dataSource = (DataSource) envCtx.lookup(JDBC_MF0223);
		} catch (NamingException e) {
			throw new AccesoDatosException("No se ha encontrado el JNDI de mf0223", e);
		}
	}
}