package br.ufrpe.account_manager.dao;

import java.util.ArrayList;

import br.ufrpe.account_manager.negocio.beans.Pessoa;

public interface IRepositorioPessoas {
	
	public boolean cadastrar(Pessoa pessoa);
	public boolean atualizar(Pessoa pessoa);
	public Pessoa procurar(String cpf);
	public ArrayList<Pessoa> listar();
	public boolean remover(String cpf);

}
