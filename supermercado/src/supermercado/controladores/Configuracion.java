package supermercado.controladores;

import supermercado.accesodatos.Dao;
import supermercado.accesodatos.DaoUsuario;
import supermercado.accesodatos.DepartamentoDaoMySql;
import supermercado.accesodatos.ProductoDaoMySql;
import supermercado.accesodatos.UsuarioDaoMySql;
import supermercado.modelos.Departamento;
import supermercado.modelos.Producto;

public class Configuracion {
	public static DaoUsuario daoUsuarios = UsuarioDaoMySql.getInstancia();
	public static Dao<Producto> daoProductos = ProductoDaoMySql.getInstancia();
	public static Dao<Departamento> daoDepartamentos = DepartamentoDaoMySql.getInstancia();
}