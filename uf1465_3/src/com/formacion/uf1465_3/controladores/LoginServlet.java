package com.formacion.uf1465_3.controladores;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.formacion.uf1465_3.accesodatos.UsuarioDao;
import com.formacion.uf1465_3.accesodatos.UsuarioDaoMySql;
import com.formacion.uf1465_3.bibliotecas.Password;
import com.formacion.uf1465_3.entidades.Usuario;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = Logger.getLogger(LoginServlet.class.getName());

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");

		UsuarioDao dao = new UsuarioDaoMySql();

		Usuario user = dao.obtenerPorUsuario(usuario);

		String hash = Password.obtenerHash(password);

		String longitud = String.valueOf(hash.length());

		LOG.info(usuario);
		LOG.info(password);
		LOG.info(hash);
		LOG.info(longitud);

		if (user!=null && hash.equals(user.getPassword())) {
			request.getSession().setAttribute("usuario", user);

			request.getRequestDispatcher("/WEB-INF/vistas/admin/usuario.jsp").forward(request, response);
			//response.sendRedirect(getServletContext().getContextPath() + "/admin/usuario");
			//response.sendRedirect(request.getContextPath() + "/admin/usuario");
		} else {
			request.setAttribute("mensaje", "El usuario o la contraseña son incorrectos");
			request.setAttribute("nivel", "danger");

			request.setAttribute("usuario", user);

			doGet(request, response);
		}
	}

}
