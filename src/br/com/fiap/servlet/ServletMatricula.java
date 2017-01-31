package br.com.fiap.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.AlunoDisciplinaDao;
import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.AlunoDisciplina;
import br.com.fiap.entity.Curso;
import br.com.fiap.entity.Disciplina;
import br.com.fiap.entity.Usuario;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet(urlPatterns = { "/admin/matricula"})
public class ServletMatricula extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletMatricula() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("matricularAluno.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			GenericDao<Usuario> usuarioDao = new GenericDao<Usuario>(Usuario.class);
			Usuario aluno = usuarioDao.buscar(Integer.parseInt(request.getParameter("aluno")));
			
			GenericDao<Curso> cursoDao = new GenericDao<Curso>(Curso.class);
			Curso curso = cursoDao.buscar(Integer.parseInt(request.getParameter("curso")));

			AlunoDisciplinaDao dao = new AlunoDisciplinaDao();
			
			for (Disciplina disciplina : curso.getDisciplinas()) {
				AlunoDisciplina alunoDisciplina= new AlunoDisciplina();
				alunoDisciplina.setAluno(aluno);
				alunoDisciplina.setDisciplina(disciplina);
				try {
					dao.deletarPorAlunoDisciplina(aluno.getId(), disciplina.getId());
				} catch (Exception e) {
				}
				dao.adicionar(alunoDisciplina);
			}
			request.setAttribute("msg", "Aluno matriculado com sucesso");
			request.getRequestDispatcher("/menu.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("msg", "Erro ao matricular Aluno " + e.getMessage());
			request.getRequestDispatcher("/menu.jsp").forward(request, response);
		}

	}

}
