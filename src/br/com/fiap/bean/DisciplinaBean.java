package br.com.fiap.bean;

import java.util.HashSet;
import java.util.Set;

import br.com.fiap.dao.DisciplinaDao;
import br.com.fiap.entity.Disciplina;

public class DisciplinaBean {

	public Set<Disciplina> getListaDisciplina(){
		DisciplinaDao dao = new DisciplinaDao();
		//return dao.listarPorProfessorId(professorId);
		HashSet<Disciplina> hashSet = new HashSet<Disciplina>();
		hashSet.addAll(dao.listar());
		return hashSet;
	}
	
}
