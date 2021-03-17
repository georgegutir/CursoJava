package com.ipartek.formacion.ejemplofinal.accesodatos;

import com.ipartek.formacion.ejemplofinal.entidades.Cliente;
import com.ipartek.formacion.ejemplofinal.entidades.Producto;

/**
 * Métodos de acceso a los datos de la fábrica que se van a usar
 * 
 * @author Jorge Gutierrez
 * @version 1.0
 */
public class DaoFabrica {

	private DaoFabrica() {}

	private static final Dao<Producto> daoProducto = new ProductoDaoMySql();
	private static final DaoFactura daoFactura = new FacturaDaoMySql();
	private static final Dao<Cliente> daoCliente = new ClienteDaoMySql();
	private static final DaoUsuario daoUsuario = new UsuarioDaoMySql();

	/**
	 * Método para la operación de obtención del Dao del producto
	 * @return daoProducto
	 */
	public static Dao<Producto> getDaoProducto() {
		return daoProducto;
	}
	
	/**
	 * Método para la operación de obtención del Dao de la factura
	 * @return daoFactura
	 */
	public static DaoFactura getDaoFactura() {
		return daoFactura;
	}
	
	/**
	 * Método para la operación de obtención del Dao del cliente
	 * @return daoCliente
	 */
	public static Dao<Cliente> getDaoCliente() {
		return daoCliente;
	}
	
	/**
	 * Método para la operación de obtención del Dao del usuario
	 * @return daoUsuario
	 */
	public static DaoUsuario getDaoUsuario() {
		return daoUsuario;
	}

}