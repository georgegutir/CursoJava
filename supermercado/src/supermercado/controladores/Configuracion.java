package supermercado.controladores;

import supermercado.accesodatos.Dao;
import supermercado.accesodatos.DaoUsuario;
import supermercado.accesodatos.ProductoDaoTreeMap;
import supermercado.accesodatos.UsuarioDaoMySql;
import supermercado.modelos.Producto;

public class Configuracion {
	public static DaoUsuario daoUsuarios = UsuarioDaoMySql.getInstancia();
	public static Dao<Producto> daoProductos = ProductoDaoTreeMap.getInstancia();
}