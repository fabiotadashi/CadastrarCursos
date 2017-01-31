package br.com.fiap.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Perfil;
import br.com.fiap.entity.Usuario;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet(urlPatterns = { "/admin/aluno"})
public class ServletAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletAluno() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("aluno.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {

			String nome = request.getParameter("nome");
			String senha = request.getParameter("senha");
			
			Usuario aluno = new Usuario();
			aluno.setNome(nome);
			aluno.setSenha(senha);
			aluno.setPerfil(Perfil.ALUNO);
			
			GenericDao<Usuario> dao = new GenericDao<Usuario>(Usuario.class);

			dao.adicionar(aluno);

			request.setAttribute("msg", "Aluno "+aluno.getNome()+" cadastrado com sucesso");
			request.getRequestDispatcher("/menu.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("msg", "Erro ao cadastrar Aluno " + e.getMessage());
			request.getRequestDispatcher("/menu.jsp").forward(request, response);
		}

	}

}
