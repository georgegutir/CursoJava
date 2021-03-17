package com.ipartek.formacion.uf1466Actividad3.controladores;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/restauracion")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
maxFileSize = 1024 * 1024 * 5, 
maxRequestSize = 1024 * 1024 * 5 * 5)
public class RestauracionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "database_backup";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(Config.PATH_VISTAS + "index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) uploadDir.mkdir();
		
		String archivo = null;
		
		for (Part part : request.getParts()) {
		    archivo = part.getSubmittedFileName();
		    
		    if(archivo != null && archivo.trim().length() > 0) {
			    part.write(uploadPath + File.separator + archivo);
			    break;
		    }
		}
		
		String restoreCmd = "mysql -uroot -e \"source " + uploadPath + File.separator + archivo + "\"";
		System.out.println(archivo);
		System.out.println(restoreCmd);
		try {
			Process runProcess = Runtime.getRuntime().exec(restoreCmd);
			int processComplete = runProcess.waitFor();
			if(processComplete == 0) {
				System.out.println("Restaurado correctamente");
				request.getRequestDispatcher(Config.PATH_VISTAS + "index.jsp").forward(request, response);
			}else {
				System.out.println("Ha habido algún error");
				doGet(request, response);
			}
		} catch (InterruptedException e) {		
			System.out.println("Proceso no completado");
			doGet(request, response);
		}		
	}

}