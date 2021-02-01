package euromillon.accesodatos;

import euromillon.modelo.Sorteos;

public interface SorteosDao extends Dao<Sorteos>{
	default void obtenerPorReferencia(String referencia) {
		throw new AccesoDatosException("ESTE MÉTODO NO ESTÁ IMPLEMENTADO");
	}

	default void borrar(String referencia) {
		throw new AccesoDatosException("ESTE MÉTODO NO ESTÁ IMPLEMENTADO");
	}
}
