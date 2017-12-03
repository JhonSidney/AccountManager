package br.ufrpe.account_manager.dao;

import java.util.ArrayList;

public interface IRepositorio<T,K> {

	public void cadastrar(T objeto);
	public void remover (T objeto);
	public void atualizar(T objeto);
	public ArrayList<T> listar();
	public T existe (T objeto);
	public boolean existeNome(K chave);
	
	
}
