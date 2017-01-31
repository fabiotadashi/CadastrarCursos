package br.com.fiap.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.entity.Perfil;
import br.com.fiap.entity.Usuario;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet(urlPatterns = { "/aluno/minhasNotas" })
public class ServletMinhasNotas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletMinhasNotas() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = ((HttpServletRequest) request).getSession();
			Usuario usuario = (Usuario) session.getAttribute("session_usuario");
			if (usuario.getPerfil() != Perfil.ALUNO) {
				throw new Exception("Usuário não é aluno");
			}
			request.setAttribute("aluno", usuario);
			request.getRequestDispatcher("minhasNotas.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("minhasNotas.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
	}

}
