package com.ipartek.formacion.uf1466Actividad3.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexionbbdd {
	
	private static final String URL="jdbc:mysql://localhost:3306/?serverTimezone=UTC";
	private static final String USER="root";
	private static final String PASS="";
	
	private static final String SQL_CREATE="CREATE DATABASE ";
	private static final String SQL_DROP="DROP DATABASE IF EXISTS ";
	
	public Conexionbbdd(){
	}

	private static final Conexionbbdd INSTANCIA = new Conexionbbdd();
	
	public static Conexionbbdd getInstancia() {
		return INSTANCIA;
	}
	
	static {
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha encontrado el driver para MySQL");
		}
	}
	
	public void createDatabase(String nombre) {
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement ps = con.prepareStatement(SQL_CREATE + nombre);){
				ps.executeUpdate();
			}catch (SQLException e) {
				throw new AccesoDatosException("No se ha podido crear la base de datos " + nombre, e);
			}		
	}
	
	public void dropDatabase(String nombre) {
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement ps = con.prepareStatement(SQL_DROP + nombre);){
			ps.executeUpdate();
		}catch (SQLException e) {
			throw new AccesoDatosException("No se ha encontrado la base de datos " + nombre, e);
		}
	}

}
