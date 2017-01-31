package br.com.fiap.dao;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Query;

import br.com.fiap.entity.AlunoDisciplina;

public class AlunoDisciplinaDao extends GenericDao<AlunoDisciplina> {
	
	public AlunoDisciplinaDao() {
		super(AlunoDisciplina.class);
	}

	@SuppressWarnings("unchecked")
	public Set<AlunoDisciplina> listarPorDisciplinaId(int disciplinaId) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select ad from AlunoDisciplina ad where ad.disciplina.id = :disciplinaId");
		query.setParameter("disciplinaId", disciplinaId);
		Set<AlunoDisciplina> listaAlunoDisciplina = new HashSet<AlunoDisciplina>();
		if(query.getResultList() != null){
			listaAlunoDisciplina.addAll(query.getResultList());
		}
		return listaAlunoDisciplina;
	}

	public void deletarPorAlunoDisciplina(int alunoId, int disciplinaId) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select ad from AlunoDisciplina ad where ad.aluno.id = :alunoId and ad.disciplina.id = :disciplinaId");
		query.setParameter("disciplinaId", disciplinaId);
		query.setParameter("alunoId", alunoId);
		AlunoDisciplina singleResult = (AlunoDisciplina) query.getSingleResult();
		if (singleResult != null){
			em.remove(singleResult);
			em.getTransaction().commit();
		}
		em.close();
	}

}
