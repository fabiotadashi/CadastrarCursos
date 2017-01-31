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
import br.com.fiap.entity.Escola;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet(urlPatterns = { "/admin/curso"})
public class ServletCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletCurso() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("curso.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {

			String nome = request.getParameter("nome");
			String descricao = request.getParameter("descricao");
			Escola escola = new Escola();
			int escolaId = Integer.parseInt(request.getParameter("escola"));
			if(escolaId <= 0){
				throw new CursoException("Selecione uma escola");
			}
			escola.setId(escolaId);
			
			Curso curso = new Curso();
			curso.setNome(nome);
			curso.setDescricao(descricao);
			curso.setEscola(escola);
				
			GenericDao<Curso> dao = new GenericDao<Curso>(Curso.class);

			dao.adicionar(curso);

			request.setAttribute("msg", "Curso "+curso.getNome()+" cadastrado com sucesso");
			request.getRequestDispatcher("/menu.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("msg", "Erro ao cadastrar Curso. " + e.getMessage());
			request.getRequestDispatcher("/menu.jsp").forward(request, response);
		}

	}

}
