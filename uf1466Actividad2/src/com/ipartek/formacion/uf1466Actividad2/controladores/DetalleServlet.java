package com.ipartek.formacion.uf1466Actividad2.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.uf1466Actividad2.accesodatos.Dao;
import com.ipartek.formacion.uf1466Actividad2.accesodatos.LibroDaoJdbc;
import com.ipartek.formacion.uf1466Actividad2.entidades.Libro;


@WebServlet("/detalle")
public class DetalleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao<Libro> dao = LibroDaoJdbc.getInstancia();
		
		String id = request.getParameter("id");

		if (id != null) {
			Libro libro = dao.obtenerPorId(Long.parseLong(id));
			request.setAttribute("libro", libro);
			request.getRequestDispatcher("/WEB-INF/vistas/detalle.jsp").forward(request, response);

		}
		request.getRequestDispatcher("/WEB-INF/vistas/libros.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
