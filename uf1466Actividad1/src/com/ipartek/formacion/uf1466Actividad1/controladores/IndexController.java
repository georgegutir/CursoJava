package com.ipartek.formacion.uf1466Actividad1.controladores;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.uf1466Actividad1.accesodatos.ClienteDaoJdbc;
import com.ipartek.formacion.uf1466Actividad1.entidades.Cliente;

@WebServlet("/clientes")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static ClienteDaoJdbc DAO = ClienteDaoJdbc.getInstancia();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		Iterable<Cliente> clientes = DAO.obtenerTodos();

		if (clientes != null) {
			request.setAttribute("clientes", clientes);
			request.getRequestDispatcher("/WEB-INF/vistas/index.jsp").forward(request, response);
		} else {
			request.setAttribute("alertaTexto", "Lista vacía, no hay clientes");
			request.setAttribute("alertaNivel", "warning");

			request.getRequestDispatcher("/WEB-INF/vistas/index.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		System.out.println("Nombre del archivo: " + nombreArchivo());

		try {
			String csv = getServletContext().getRealPath(nombreArchivo());
			FileWriter fw = new FileWriter(csv);
			PrintWriter pw = new PrintWriter(fw);

			Iterable<Cliente> clientes = DAO.obtenerTodos();

			for (Cliente cliente : clientes) {
				System.out.println(cliente);
				pw.println(cliente.getCodigo() + ";" + cliente.getNombre() + ";" + cliente.getEmail() + ";" + cliente.getTelefono() + ";" 
						+ cliente.getDireccion() + ";" + cliente.getPoblacion() + ";" + cliente.getCodigopostal() + ";" + cliente.getIdentificador() + ";" 
						+ cliente.getActivo() + ";");
			}
			System.out.println("archivo csv " + csv + " guardado");
			pw.close();
			fw.close();
			doGet(request, response);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Función para crear el formato con la fecha actual del nombre del archivo csv creado
	private static String nombreArchivo() {

		Date fechaActual = new Date();

		DateFormat formatoHora = new SimpleDateFormat("HH-mm-ss");
		DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

		return (formatoFecha.format(fechaActual) + "-" + formatoHora.format(fechaActual) + ".csv");
		}

}