package supermercado.controladores.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import supermercado.controladores.Configuracion;
import supermercado.modelos.Producto;

@WebServlet("/admin/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String borrados = request.getParameter("borrados");

		Iterable<Producto> productos = borrados != null ? Configuracion.daoProductos.obtenerBorrados() : Configuracion.daoProductos.obtenerTodos();

		request.setAttribute("borrados", borrados);
		request.setAttribute("productos", productos);
		request.getRequestDispatcher("/WEB-INF/vistas/admin/index.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}