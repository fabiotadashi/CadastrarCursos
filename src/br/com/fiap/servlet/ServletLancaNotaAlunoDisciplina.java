package br.com.fiap.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.AlunoDisciplinaDao;
import br.com.fiap.entity.AlunoDisciplina;

@WebServlet(urlPatterns = { "/professor/lancarNotasAluno" })
public class ServletLancaNotaAlunoDisciplina extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletLancaNotaAlunoDisciplina() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			AlunoDisciplinaDao dao = new AlunoDisciplinaDao();
			AlunoDisciplina alunoDisciplina = null;
			if (request.getParameter("alunoDisciplina") != null && !request.getParameter("alunoDisciplina").equals("")) {
				alunoDisciplina = dao.buscar(Integer.parseInt(request.getParameter("alunoDisciplina")));
			}
			request.setAttribute("alunoDisciplina", alunoDisciplina);
			request.getRequestDispatcher("lancarNotasAluno.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("lancarNotasAluno.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		AlunoDisciplinaDao dao = new AlunoDisciplinaDao();
		AlunoDisciplina alunoDisciplina = dao.buscar(Integer.parseInt(request.getParameter("id")));
		if(alunoDisciplina != null){
			alunoDisciplina.setAtividadePratica(Integer.parseInt(request.getParameter("atividadePratica")));
			alunoDisciplina.setProjeto1(Integer.parseInt(request.getParameter("projeto1")));
			alunoDisciplina.setProjeto2(Integer.parseInt(request.getParameter("projeto2")));
			dao.atualizar(alunoDisciplina);
		}
		response.sendRedirect("/CadastroCursos/professor/lancarNotas?disciplina="+alunoDisciplina.getDisciplina().getId());
	}

}
