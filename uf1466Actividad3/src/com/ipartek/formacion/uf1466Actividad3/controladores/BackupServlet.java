package com.ipartek.formacion.uf1466Actividad3.controladores;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.uf1466Actividad3.accesodatos.Conexionbbdd;

@WebServlet("/backup")
public class BackupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Conexionbbdd con = Conexionbbdd.getInstancia();
		String nombre = request.getParameter("nombre");
		
		//Copiar bbdd
		Process p = Runtime.getRuntime().exec("mysqldump -u root gestiondocente");
		System.out.println("Iniciando grabación de bbdd");
		
		try (InputStream is = p.getInputStream(); FileOutputStream fos = new FileOutputStream("C:/Users/JORGE/Downloads/" + nombre + ".sql")) {
			byte[] buffer = new byte[1000];

			int leido;
			while ((leido = is.read(buffer)) > 0) {
				fos.write(buffer, 0, leido);
			}
		} 

		int processComplete = 0;
		try {
			processComplete = p.waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (processComplete == 0) {
			System.out.println(nombre + ".sql guardado correctamente");
		} else {
			System.out.println("Ha habido algún error");
		}
		
		//eliminar y crear nueva copia de bbdd
		con.dropDatabase(nombre);
		con.createDatabase(nombre);
		
		//Restauro la nueva bbdd
		try {
			Process p2 = Runtime.getRuntime().exec("mysql -u root " + nombre);

			OutputStream os = p2.getOutputStream();
			FileInputStream fis = new FileInputStream("C:/Users/JORGE/Downloads/" + nombre + ".sql");
			byte[] buffer2 = new byte[1000];

			int leido2 = fis.read(buffer2);
			while (leido2 > 0) {
			         os.write(buffer2, 0, leido2);
			         leido2 = fis.read(buffer2);
			}

			os.flush();
			os.close();
			fis.close();
			System.out.println("Base de datos " + nombre + ".sql creada correctamente");

		} catch (Exception e) {
			System.out.println("Error en la creacion de la base de datos " + nombre);
		}
		
		request.getRequestDispatcher(Config.PATH_VISTAS + "index.jsp").forward(request,  response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
