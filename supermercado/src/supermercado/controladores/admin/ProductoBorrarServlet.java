package supermercado.controladores.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import supermercado.accesodatos.Dao;
import supermercado.controladores.Configuracion;
import supermercado.modelos.Producto;

@WebServlet("/admin/borrar")
public class ProductoBorrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");

		Dao<Producto> dao = Configuracion.daoProductos;

		dao.eliminar(Long.parseLong(id));

		request.setAttribute("alertaTexto", "Borrado efectuado correctamente");
		request.setAttribute("alertaNivel", "success");

		request.getRequestDispatcher("/admin/index").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}