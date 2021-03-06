package com.ipartek.formacion.uf1466Actividad2.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/restauracion")
public class RestauracionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Iniciando restauración");
		String usuario = "root";
		String password = "";
		String archivo ="C:/Users/JORGE/UF1466_2.sql";
		String[] restoreCmd = new String[] { "mysql ", "--user=" + usuario, "--password=" + password, "-e",
				"source " + archivo };

		 Process runProcess = Runtime.getRuntime().exec(restoreCmd);
		 int processComplete = 0;
		try {
			processComplete = runProcess.waitFor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 if(processComplete == 0) {
			 System.out.println("Restaurado con éxito");
			 request.getRequestDispatcher("/WEB-INF/vistas/menu.jsp").forward(request, response);
		 } else {
			 System.out.println("Ha habido algún error");
		 }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
