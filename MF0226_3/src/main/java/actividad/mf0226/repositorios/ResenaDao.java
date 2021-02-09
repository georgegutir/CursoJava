package actividad.mf0226.repositorios;

import actividad.mf0226.entidades.Resena;

public interface ResenaDao extends Dao<Resena> {
	
	Resena obtenerPorId(int id);
	
	Resena insertar(Resena r);

	Resena modificar(Resena r);

	void borrar(int id);

}
