package com.ipartek.formacion.uf1466_1.controladores;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.uf1466_1.accesodatos.ClienteDaoJdbc;
import com.ipartek.formacion.uf1466_1.entidades.Cliente;

@Controller
@RequestMapping("/")
public class IndexController{

	private static ClienteDaoJdbc DAO = ClienteDaoJdbc.getInstancia();

	@GetMapping
	protected String get(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		return "index";
	}

	@PostMapping
	protected void post(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		System.out.println("Nombre del archivo: " + nombreArchivo());

		try {
			FileWriter fw = null;
			fw = new FileWriter(nombreArchivo());

			PrintWriter pw = null;
			pw = new PrintWriter(fw);

			Iterable<Cliente> clientes = DAO.obtenerTodos();

			for (Cliente cliente : clientes) {
				System.out.println(cliente);
				pw.println(cliente.getCodigo() + ";" + cliente.getNombre() + ";" + cliente.getEmail() + ";" + cliente.getTelefono() + ";" 
						+ cliente.getDireccion() + ";" + cliente.getPoblacion() + ";" + cliente.getCodigopostal() + ";" + cliente.getIdentificador() + ";" 
						+ cliente.getActivo() + ";");
			}
			System.out.println("csv guardado");
			pw.close();
			fw.close();
			
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
