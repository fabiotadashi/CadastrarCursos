package br.com.fiap.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.Exception.CursoException;
import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Curso;
import br.com.fiap.entity.Disciplina;
import br.com.fiap.entity.Usuario;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet(urlPatterns = { "/admin/disciplina"})
public class ServletDisciplina extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletDisciplina() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("disciplina.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {

			String nome = request.getParameter("nome");
			String descricao = request.getParameter("descricao");
			Curso curso = new Curso();
			int cursoId = Integer.parseInt(request.getParameter("curso"));
			if(cursoId <= 0){
				throw new CursoException("Selecione um curso");
			}
			curso.setId(cursoId);
			
			Usuario professor = new Usuario();
			professor.setId(Integer.parseInt(request.getParameter("professor")));
			
			Disciplina disciplina = new Disciplina();
			disciplina.setNome(nome);
			disciplina.setDescricao(descricao);
			disciplina.setCurso(curso);
			disciplina.setProfessor(professor);
				
			GenericDao<Disciplina> dao = new GenericDao<Disciplina>(Disciplina.class);

			dao.adicionar(disciplina);

			request.setAttribute("msg", "Disciplina "+disciplina.getNome()+" cadastrada com sucesso");
			request.getRequestDispatcher("/menu.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("msg", "Erro ao cadastrar Disciplina. " + e.getMessage());
			request.getRequestDispatcher("/menu.jsp").forward(request, response);
		}

	}

}
