package br.com.fiap.servlet;

import java.io.IOException;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.CursoDao;
import br.com.fiap.entity.Curso;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet(urlPatterns = { "/admin/listarCursos" })
public class ServletListaCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletListaCurso() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			CursoDao dao = new CursoDao();
			HashSet<Curso> listaCursos = new HashSet<>();
			int professorId;
			if (request.getParameter("professor") != null && !request.getParameter("professor").equals("")) {
				professorId = Integer.parseInt(request.getParameter("professor"));
				listaCursos = dao.listarPorProfessorId(professorId);
			}
			request.setAttribute("listaCursos", listaCursos);
			request.getRequestDispatcher("listarCursos.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("listarCursos.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
	}

}
