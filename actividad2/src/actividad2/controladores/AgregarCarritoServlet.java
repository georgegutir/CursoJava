package actividad2.controladores;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Enumeration;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import actividad2.accesodatos.Dao;
import actividad2.accesodatos.ProductoDaoTreeMap;
import actividad2.modelos.Producto;

@WebServlet("/agregarcarrito")
public class AgregarCarritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Dao<Producto> dao = ProductoDaoTreeMap.getInstancia();

		LinkedHashMap<Long, Producto> carrito = new LinkedHashMap<>();

		Enumeration<String> ids = request.getParameterNames();

		String sId;
		Long id;
		Integer cantidad;
		BigDecimal totalCompra;

		Producto producto;

		while (ids.hasMoreElements()) {
			sId = ids.nextElement();
			id = Long.parseLong(sId);
			cantidad = Integer.parseInt(request.getParameter(sId));
			totalCompra = new BigDecimal(0);

			if (cantidad > 0) {

				producto = dao.obtenerPorId(id);
				producto.setCantidad(cantidad);
				
				producto.getTotalProducto();

				carrito.put(id, producto);
				//totalCompra = totalCompra.add(producto.getPrecio().multiply(new BigDecimal(cantidad)));
				totalCompra = totalCompra.add(producto.getTotalProducto());
			}
			request.getSession().setAttribute("totalCompra", totalCompra);
		}

		request.getSession().setAttribute("carrito", carrito);

		response.sendRedirect(request.getContextPath() + "/carrito");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}