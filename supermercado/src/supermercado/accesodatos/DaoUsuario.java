package supermercado.accesodatos;

import supermercado.modelos.Usuario;

public interface DaoUsuario extends Dao<Usuario> {
	Usuario obtenerPorEmail(String email);
}
