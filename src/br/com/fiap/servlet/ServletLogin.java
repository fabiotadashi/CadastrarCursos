package br.com.fiap.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.entity.Perfil;
import br.com.fiap.entity.Usuario;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet(urlPatterns = { "/login"})
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletLogin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			String nome = request.getParameter("nome");
			String senha = request.getParameter("senha");
			UsuarioDao dao = new UsuarioDao();
			Usuario usuario = dao.buscarUsuario(nome, senha);
			if (usuario != null) {
				HttpSession session = request.getSession();
				session.setAttribute("session_usuario", usuario);
				if(usuario.getPerfil() == Perfil.ADMIN){
					response.sendRedirect("admin/menu.jsp");
				}else if(usuario.getPerfil() == Perfil.PROFESSOR){
					response.sendRedirect("professor/menu.jsp");
				}else if(usuario.getPerfil() == Perfil.ALUNO){
					response.sendRedirect("aluno/minhasNotas");
				}
			} else {
				request.setAttribute("msg", "Usuario ou senha inválido(s)");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("msg", "Usuario ou senha inválido(s)");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			e.printStackTrace();
		}

	}

}
