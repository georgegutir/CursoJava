package com.formacion.uf1465.controladores;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.formacion.uf1465.accesodatos.Dao;
import com.formacion.uf1465.accesodatos.ProductoDaoMySql;
import com.formacion.uf1465.entidades.Producto;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao<Producto> dao = new ProductoDaoMySql();
		Iterable<Producto> productos = dao.obtenerTodos();

		request.setAttribute("productos", productos);
		request.getRequestDispatcher("/WEB-INF/vistas/index.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}