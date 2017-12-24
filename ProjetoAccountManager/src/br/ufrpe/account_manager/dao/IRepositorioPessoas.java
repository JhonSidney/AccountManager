package br.ufrpe.account_manager.dao;

import java.util.ArrayList;

import br.ufrpe.account_manager.negocio.beans.Pessoa;

public interface IRepositorioPessoas<T,K> {

	public void cadastrar(Pessoa pessoa);
	public void remover(Pessoa pessoa);
	public ArrayList<Pessoa> listar();
	public void atualizar(Pessoa pessoa);
	public Pessoa procurar(String cpf);
	//implementado acima
	public Pessoa existe(Pessoa pessoa);
	public  Pessoa existe(String nome);
	public boolean existeNome(String cpf);
	
}
