package br.com.fiap.dao;

import java.util.List;

public interface Dao<T> {
	void adicionar(T entidade);
	void atualizar(T entidade);
	 List<T> listar();
	 T buscar(int id); 
}
