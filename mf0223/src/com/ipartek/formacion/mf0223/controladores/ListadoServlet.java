package com.ipartek.formacion.mf0223.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.mf0223.accesodatos.PlatoDaoMySql;
import com.ipartek.formacion.mf0223.entidades.Plato;

/**
 * Controlador que muestra la lista de todos los platos de la bbdd
 * 
 * @author Jorge Gutierrez
 * @version 1.0
 */
@WebServlet("/listado")
public class ListadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		PlatoDaoMySql dao = new PlatoDaoMySql();
		Iterable<Plato> platos = dao.obtenerTodos();

		if (platos != null) {
			request.setAttribute("platos", platos);
			request.getRequestDispatcher(Config.PATH_VISTAS + "listado.jsp").forward(request, response);

		} else {
			request.setAttribute("alertaTexto", "No hay platos");
			request.setAttribute("alertaNivel", "warning");

			request.getRequestDispatcher(Config.PATH_VISTAS + "index.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.sendRedirect(request.getContextPath() + "/insertar");
	}

}
