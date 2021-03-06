package com.ipartek.formacion.uf1466Actividad2.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.uf1466Actividad2.accesodatos.Dao;
import com.ipartek.formacion.uf1466Actividad2.accesodatos.LibroDaoJdbc;
import com.ipartek.formacion.uf1466Actividad2.entidades.Libro;

@WebServlet("/buscarISBN")
public class BuscarISBNServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/vistas/menu.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String solicitud = request.getParameter("isbn");
		Dao<Libro> dao = LibroDaoJdbc.getInstancia();
		Libro libro = null;
		ArrayList<Libro> librosArray = new ArrayList<>();
		libro = dao.obtenerPorISBN(solicitud);
		
		if (libro != null) {
			librosArray.add(libro);
			request.setAttribute("libros", librosArray);
		}
		request.getRequestDispatcher("/WEB-INF/vistas/busqueda.jsp").forward(request, response);
	}

}
