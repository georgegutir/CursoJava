package com.ipartek.formacion.uf1466Actividad3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class App {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		final String URL = "jdbc:mysql://localhost:3306/?serverTimezone=UTC";
		final String USER = "root";
		final String PASS = "";
		
		//conexion a la bbdd
		Statement s;
		int processComplete;
		try {
			Connection con;
			con = DriverManager.getConnection(URL, USER, PASS);
			s = con.createStatement();
			
			s.executeUpdate("show databases");
			
			//backup de la bbdd
			Process p = Runtime.getRuntime().exec("mysqldump -u root gestiondocente");
			
			InputStream is = p.getInputStream();
			FileOutputStream fos = new FileOutputStream("gestiondocentecopiaapp.sql");
			byte[] buffer = new byte[1000];
			
			int leido;
			while((leido = is.read(buffer)) > 0) {
				fos.write(buffer, 0, leido);
			}
			
			processComplete = p.waitFor();
			
			if (processComplete == 0) {
				System.out.println("backup correcto");
			} else {
				System.out.println("Ha habido algún error");
			}
			
			//eliminar copia de la bbdd
			try {
				s.executeUpdate("DROP DATABASE gestiondocentecopiaapp");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//crear la copia
			s.executeUpdate("CREATE DATABASE gestiondocentecopiaapp");
			//cerrar conexión con bbdd
			con.close();
			
			//conectar a la nueva bbdd
			con = DriverManager.getConnection(URL, USER, PASS);
			s = con.createStatement();
			
			//restaurar el backup
			Process p2 = Runtime.getRuntime().exec("mysql -u root gestiondocentecopiaapp");
			
			OutputStream os = p2.getOutputStream();
			FileInputStream fis = new FileInputStream("gestiondocentecopiaapp.sql");
			byte[] buffer2 = new byte[1000];
			
			int leido2 = fis.read(buffer2);
			while (leido2 > 0) {
				os.write(buffer2, 0, leido2);
				leido2 = fis.read(buffer2);
			}
			System.out.println("BBDD restaurada");
			
			os.flush();
			os.close();
			fis.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
