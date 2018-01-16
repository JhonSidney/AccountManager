package br.ufrpe.account_manager.dao;

import java.util.ArrayList;

import br.ufrpe.account_manager.negocio.beans.Contato;
import br.ufrpe.account_manager.negocio.beans.Pessoa;

public interface IRepositorioContatos {

	
	public boolean cadastrar(Contato contato);
	public boolean atualizar(Contato contato);
	public Contato procurar(String cpf);
	public ArrayList<Contato> listar();
	public boolean remover(String cpf);
	
	
	
	
}

