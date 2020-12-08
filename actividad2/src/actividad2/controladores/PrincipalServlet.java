package actividad2.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import actividad2.accesodatos.Dao;
import actividad2.accesodatos.ProductoDaoTreeMap;
import actividad2.modelos.Producto;

@WebServlet("/principal")
public class PrincipalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao<Producto> dao = ProductoDaoTreeMap.getInstancia();
		Iterable<Producto> productos = dao.obtenerTodos();
		request.setAttribute("productos", productos);
		request.getRequestDispatcher("/WEB-INF/vistas/principal.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
