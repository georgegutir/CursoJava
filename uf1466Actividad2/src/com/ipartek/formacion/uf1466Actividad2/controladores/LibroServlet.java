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

@WebServlet("/libros")
public class LibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		Dao<Libro> dao = LibroDaoJdbc.getInstancia();
		Iterable<Libro> libros = dao.obtenerTodos();

		if (libros != null) {
			request.setAttribute("libros", libros);
			request.getRequestDispatcher("/WEB-INF/vistas/libros.jsp").forward(request, response);

		} else {
			request.setAttribute("alertaTexto", "No hay libros");
			request.setAttribute("alertaNivel", "warning");

			request.getRequestDispatcher("/WEB-INF/vistas/menu.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		request.getRequestDispatcher("/WEB-INF/vistas/menu.jsp").forward(request, response);
	}

}
