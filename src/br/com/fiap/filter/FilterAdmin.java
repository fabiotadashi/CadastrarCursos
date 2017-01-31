package br.com.fiap.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.entity.Perfil;
import br.com.fiap.entity.Usuario;

@WebFilter("/admin/*")
public class FilterAdmin implements Filter {

    public FilterAdmin() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		Usuario usuario = (Usuario)session.getAttribute("session_usuario");
		if(usuario == null){
			((HttpServletResponse) response).sendRedirect("/CadastroCursos/login.jsp");
		}else if(usuario.getPerfil() != Perfil.ADMIN){
			request.setAttribute("msg", "Usuário sem permissão de acesso");
			request.getRequestDispatcher("/menu.jsp").forward(request, response);
		}else{
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
