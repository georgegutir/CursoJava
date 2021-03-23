package com.ipartek.formacion.mf0223.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.mf0223.entidades.Alerta;
import com.ipartek.formacion.mf0223.entidades.Categoria;
import com.ipartek.formacion.mf0223.entidades.Plato;
import com.ipartek.formacion.mf0223.entidades.Procedencia;

/**
 * Controlador que guarda un nuevo plato en la bbdd
 * 
 * @author Jorge Gutierrez
 * @version 1.0
 */
@WebServlet("/insertar")
public class InsertarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Iterable<Categoria> categorias= Config.categoriaNegocio.listadoCategorias();
		request.setAttribute("categorias", categorias);	
		
		Iterable<Procedencia> procedencias= Config.procedenciaNegocio.listadoProcedencia();
		request.setAttribute("procedencias", procedencias);
		
		request.getRequestDispatcher(Config.PATH_VISTAS + "insertar.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String nombre = request.getParameter("nombre");
		String calorias = request.getParameter("calorias");
		String cat = request.getParameter("categoria");
		String proc = request.getParameter("procedencia"); 

		int calInt = Integer.parseInt(calorias);
		Long catId = Long.parseLong(cat);
		Long procId = Long.parseLong(proc);
		
		Plato plato = new Plato(1L, nombre, calInt, null, null);

		plato.setCategoria(new Categoria(catId, null, null));
		plato.setProcedencia(new Procedencia(procId, null, null));

		try {
			Config.platoNegocio.insertarPlato(plato);
			request.getSession().setAttribute("alerta", new Alerta("success", "Plato guardado correctamente"));
		} catch (Exception e) {
			request.setAttribute("alerta", new Alerta("danger", "No se ha podido agregar el nuevo plato"));
		}

		response.sendRedirect(request.getContextPath() + "/listado");
	}

}
