package ferreteria.controladores;

import java.io.IOException;
import java.util.Enumeration;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ferreteria.accesodatos.Dao;
import ferreteria.accesodatos.ProductoDaoTreeMap;
import ferreteria.modelos.Producto;

@WebServlet("/agregartodocarrito")
public class AgregarTodoCarritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.setContentType("text/plain");
//		PrintWriter out = response.getWriter();

		Dao<Producto> dao = ProductoDaoTreeMap.getInstancia();

		LinkedHashMap<Long, Producto> carrito = new LinkedHashMap<>();

		Enumeration<String> ids = request.getParameterNames();

		String sId;
		Long id;
		Integer cantidad;

		Producto producto;

		while (ids.hasMoreElements()) {
			sId = ids.nextElement();
			id = Long.parseLong(sId);
			cantidad = Integer.parseInt(request.getParameter(sId));

			if (cantidad > 0) {
//				out.println(id + ": " + cantidad);

				producto = dao.obtenerPorId(id);
				producto.setCantidad(cantidad);

				carrito.put(id, producto);

//				out.println(producto);
			}
		}

		request.getSession().setAttribute("carrito", carrito);

		response.sendRedirect(request.getContextPath() + "/carrito");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
