package br.ufrpe.account_manager.dao;

import java.util.ArrayList;

import br.ufrpe.account_manager.negocio.beans.Contatos;

public interface IRepositorioContatos {

	public void cadastrar(Contatos contato);
	public void remover(Contatos contato);
	public void atualizar (Contatos contato);
	public boolean existe(Contatos contato);
	public ArrayList<Contatos> listar();
	public Contatos procurar (Contatos contato);
	
}
