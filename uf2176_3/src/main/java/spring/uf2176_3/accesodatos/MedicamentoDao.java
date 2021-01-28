package spring.uf2176_3.accesodatos;

import spring.uf2176_3.entidades.Medicamento;

public interface MedicamentoDao extends Dao<Medicamento>{

	default void obtenerPorReferencia(String referencia) {
		throw new AccesoDatosException("ESTE MÉTODO NO ESTÁ IMPLEMENTADO");
	}

	default void borrar(String referencia) {
		throw new AccesoDatosException("ESTE MÉTODO NO ESTÁ IMPLEMENTADO");
	}
}
