package com.ipartek.formacion.mf0223.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.mf0223.accesodatos.PlatoDaoMySql;
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
		Iterable<Categoria> categoria= Config.categoriaNegocio.listadoCategoria();
		request.setAttribute("categorias",categoria);	
		
		Iterable<Procedencia> procedencia = Config.procedenciaNegocio.listadoProcedencia();		
		
		request.setAttribute("origenes",procedencia);
		request.getRequestDispatcher(Config.PATH_VISTAS + "insertar.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		// 1. Recoger información de la petición
		String numId = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String calorias = request.getParameter("calorias");
		String catId = request.getParameter("categoria");
		String procId = request.getParameter("procedencia"); 

		// 2. Poner información dentro de un modelo
		Long IdLong = Long.parseLong(numId);
		int calInt = Integer.parseInt(calorias);
		Long catIdLong = Long.parseLong(catId);
		Long procIdLong = Long.parseLong(procId);
		
		Plato plato = new Plato(IdLong, nombre, calInt, null, null);

		plato.setCategoria(new Categoria(catIdLong, null, null));
		plato.setProcedencia(new Procedencia(procIdLong, null, null));
		
		System.out.println(plato);

		// 3. Tomar decisiones según lo recibido
		String texto;
		PlatoDaoMySql dao = new PlatoDaoMySql();
		dao.insertar(plato);

		texto = "Se ha creado el plato correctamente";
	
		// 4. Generar modelo para la vista
		Alerta alerta = new Alerta("success", texto);
		request.setAttribute("alerta", alerta);

		// 5. Redirigir a otra vista
		request.getRequestDispatcher("/listado").forward(request, response);
	}

}
