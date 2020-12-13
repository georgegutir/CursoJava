package libreria.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/admin/*")
public class AdminFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;

		HttpSession session = req.getSession();

		String usuario = (String) session.getAttribute("usuario");

		if(usuario == null) {
			res.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		// Nos envía a donde hubiéramos ido sin filtro
		chain.doFilter(request, response);
	}

}