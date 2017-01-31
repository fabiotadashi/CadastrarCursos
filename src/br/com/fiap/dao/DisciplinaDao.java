package br.com.fiap.dao;

import java.util.HashSet;
import java.util.List;

import javax.persistence.Query;

import br.com.fiap.entity.Disciplina;

public class DisciplinaDao extends GenericDao<Disciplina> {
	
	public DisciplinaDao() {
		super(Disciplina.class);
	}

	@SuppressWarnings("unchecked")
	public HashSet<Disciplina> listarPorProfessorId(int professorId) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select d from Disciplina d professor.id = :professorId");
		query.setParameter("professorId", professorId);
		List<Disciplina> listaDisciplina = null;
		if(query.getResultList() != null){
			listaDisciplina = (List<Disciplina>) query.getResultList();
		}
		return new HashSet<Disciplina>(listaDisciplina);
	}

}
