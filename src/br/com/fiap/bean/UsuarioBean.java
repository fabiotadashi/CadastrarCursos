package br.com.fiap.bean;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.JpaUtil;
import br.com.fiap.entity.Usuario;

public class UsuarioBean {

	public List<Usuario> getListaProfessor() {
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findProfessores", Usuario.class);
		List<Usuario> results = query.getResultList();
		em.getTransaction().commit();
		em.close();
		return results;
	}

	public List<Usuario> getListaAlunos() {
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findAlunos", Usuario.class);
		List<Usuario> results = query.getResultList();
		em.getTransaction().commit();
		em.close();
		return results;
	}

}
