package com.ipartek.formacion.mf0223.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.mf0223.entidades.Categoria;
import com.ipartek.formacion.mf0223.entidades.Plato;

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
		request.getRequestDispatcher(Config.PATH_VISTAS + "insertar.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		// 1. Recoger información de la petición
		String sId = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String calorias = request.getParameter("calorias");

		String categoriaId = request.getParameter("categoria"); // Categoría
		String procedenciaId = request.getParameter("procedencia"); // Origen

		// 2. Poner información dentro de un modelo
		Plato plato = new Plato(sId, nombre, calorias);

		Long categoriaIdLong = Long.parseLong(categoriaId);
		Long origenIdLong = Long.parseLong(procedenciaId);

		plato.setCategoria(new Categoria(categoriaIdLong, null));
		plato.setOrigen(new Origen(origenIdLong, null));

		log.info(plato.toString());

		if (!plato.isCorrecto()) {
			// 4. Generar modelo para la vista
			if (plato.getId() == null) {
				request.setAttribute("accion", "Nuevo ");
			} else {
				request.setAttribute("accion", "Edición de ");
			}

			request.setAttribute("plato", plato);

			request.setAttribute("categorias", Config.categoriaNegocio.listadoCategorias());
			request.setAttribute("origenes", Config.origenNegocio.listadoOrigenes());

			// 5. Redirigir a otra vista
			request.getRequestDispatcher(Config.PATH_VISTAS + "plato.jsp").forward(request, response);
			return;
		}

		// 3. Tomar decisiones según lo recibido
		String texto;

		if (plato.getId() == null) {
			// Si no está rellenado el id, es que queremos añadir
			Config.platoNegocio.insertarPlato(plato);

			texto = "Se ha creado el plato correctamente";
		} else {
			// Si está rellenado el id, es que queremos modificar
			Config.platoNegocio.modificarPlato(plato);

			texto = "Se ha modificado el plato correctamente";
		}

		// 4. Generar modelo para la vista
		Alerta alerta = new Alerta("success", texto);
		request.setAttribute("alerta", alerta);

		// 5. Redirigir a otra vista
		request.getRequestDispatcher("/index").forward(request, response);
	}

}
