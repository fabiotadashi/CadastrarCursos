package br.com.fiap.dao;

import java.util.HashSet;
import java.util.List;

import javax.persistence.Query;

import br.com.fiap.entity.Curso;

public class CursoDao extends GenericDao<Curso> {
	
	public CursoDao() {
		super(Curso.class);
	}

	@SuppressWarnings("unchecked")
	public HashSet<Curso> listarPorProfessorId(int professorId) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select c from Curso c left join c.disciplinas d where d.professor.id = :professorId");
		query.setParameter("professorId", professorId);
		List<Curso> listaCurso = null;
		if(query.getResultList() != null){
			listaCurso = (List<Curso>) query.getResultList();
		}
		return new HashSet<Curso>(listaCurso);
	}

}
