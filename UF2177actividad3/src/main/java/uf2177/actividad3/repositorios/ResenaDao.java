package uf2177.actividad3.repositorios;

import uf2177.actividad3.entidades.Resena;

public interface ResenaDao extends Dao<Resena> {
	
	Resena insertar(Resena r);
}
