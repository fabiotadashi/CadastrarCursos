package br.com.fiap.servlet;

import java.io.IOException;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.entity.Usuario;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet(urlPatterns = { "/professor/listarAlunos" })
public class ServletListaAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletListaAluno() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			if (request.getParameter("professor") != null && !request.getParameter("professor").equals("")
					&& request.getParameter("curso") != null && !request.getParameter("curso").equals("")) {
				throw new Exception("Selecione apenas um parâmetro");
			}

			UsuarioDao dao = new UsuarioDao();
			HashSet<Usuario> listaUsuarios = new HashSet<>();
			int professorId;
			if (request.getParameter("professor") != null && !request.getParameter("professor").equals("")) {
				professorId = Integer.parseInt(request.getParameter("professor"));
				listaUsuarios = dao.listarPorProfessorId(professorId);
			}
			int cursoId;
			if (request.getParameter("curso") != null && !request.getParameter("curso").equals("")) {
				cursoId = Integer.parseInt(request.getParameter("curso"));
				listaUsuarios = dao.listarPorCursoId(cursoId);
			}
			request.setAttribute("listaAlunos", listaUsuarios);
			request.getRequestDispatcher("listarAlunos.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("listarAlunos.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
	}

}
