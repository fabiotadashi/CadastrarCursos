package br.com.fiap.bean;

import java.util.List;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Curso;

public class CursoBean {

	public List<Curso> getListaCurso(){
		GenericDao<Curso> dao = new GenericDao<Curso>(Curso.class);
		return dao.listar();
	}
	
}
