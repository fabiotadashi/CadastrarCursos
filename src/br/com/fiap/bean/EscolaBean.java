package br.com.fiap.bean;

import java.util.List;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Escola;

public class EscolaBean {

	public List<Escola> getListaEscola(){
		GenericDao<Escola> dao = new GenericDao<Escola>(Escola.class);
		return dao.listar();
	}
	
}
