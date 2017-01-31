package br.com.fiap.servlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.AlunoDisciplinaDao;
import br.com.fiap.entity.AlunoDisciplina;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet(urlPatterns = { "/professor/lancarNotas" })
public class ServletLancaNotas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletLancaNotas() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			AlunoDisciplinaDao dao = new AlunoDisciplinaDao();
			Set<AlunoDisciplina> listaAlunoDisciplina = new HashSet<AlunoDisciplina>();
			int disciplinaId;
			if (request.getParameter("disciplina") != null && !request.getParameter("disciplina").equals("")) {
				disciplinaId = Integer.parseInt(request.getParameter("disciplina"));
				listaAlunoDisciplina = dao.listarPorDisciplinaId(disciplinaId);
			}
			request.setAttribute("listaAlunos", listaAlunoDisciplina);
			request.getRequestDispatcher("lancarNotas.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("lancarNotas.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println(request.toString());
		request.getRequestDispatcher("lancarNotas.jsp").forward(request, response);
	}

}
