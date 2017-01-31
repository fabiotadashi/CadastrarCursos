package br.com.fiap.dao;

import java.util.HashSet;
import java.util.List;

import javax.persistence.Query;

import br.com.fiap.entity.Usuario;

public class UsuarioDao extends GenericDao<Usuario> {

	
	public UsuarioDao() {
		super(Usuario.class);
	}

	public Usuario buscarUsuario(String nome, String senha){
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select u from Usuario u where nome = :nome and senha = :senha");
		query.setParameter("nome", nome);
		query.setParameter("senha", senha);
		Usuario usuario = null;
		if(query.getSingleResult() != null){
			usuario = (Usuario) query.getSingleResult();
		}
		return usuario;
	}

	@SuppressWarnings("unchecked")
	public HashSet<Usuario> listarPorProfessorId(int professorId) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select u from Usuario u inner join u.alunoDisciplina ad inner join ad.disciplina d where d.professor.id = :professorId");
		query.setParameter("professorId", professorId);
		List<Usuario> listaUsuario = null;
		if(query.getResultList() != null){
			listaUsuario = (List<Usuario>) query.getResultList();
		}
		return new HashSet<Usuario>(listaUsuario);
	}

	@SuppressWarnings("unchecked")
	public HashSet<Usuario> listarPorCursoId(int cursoId) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select u from Usuario u inner join u.alunoDisciplina ad inner join ad.disciplina d where d.curso.id = :cursoId");
		query.setParameter("cursoId", cursoId);
		List<Usuario> listaUsuario = null;
		if(query.getResultList() != null){
			listaUsuario = (List<Usuario>) query.getResultList();
		}
		return new HashSet<Usuario>(listaUsuario);
	}

}
