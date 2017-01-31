package br.com.fiap.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Escola;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet(urlPatterns = { "/admin/escola"})
public class ServletEscola extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletEscola() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("escola.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {

			String nome = request.getParameter("nome");

			Escola escola = new Escola();
			escola.setNome(nome);

			GenericDao<Escola> dao = new GenericDao<Escola>(Escola.class);

			dao.adicionar(escola);

			request.setAttribute("msg", "Escola "+escola.getNome()+" cadastrada com sucesso");
			request.getRequestDispatcher("/menu.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("msg", "Erro ao cadastrar Escola " + e.getMessage());
			request.getRequestDispatcher("/menu.jsp").forward(request, response);
		}

	}

}
