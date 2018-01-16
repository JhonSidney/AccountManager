package br.ufrpe.account_manager.dao;

import java.util.ArrayList;

import br.ufrpe.account_manager.negocio.beans.Contato;
import br.ufrpe.account_manager.negocio.beans.Pessoa;

public interface IRepositorioContatos {

	/*public void cadastrar(Contato contato);
	public void remover(Contato contato);
	public void atualizar (Contato contato);
	public boolean existe(Contato contato);
	public ArrayList<Contato> listar();
	public Contato procurar (Contato contato);
	*/
	
	public boolean cadastrar(Contato contato);
	public boolean atualizar(Contato contato);
	public Contato procurar(String cpf);
	public ArrayList<Contato> listar();
	public boolean remover(String cpf);
	
	
	
	
}

