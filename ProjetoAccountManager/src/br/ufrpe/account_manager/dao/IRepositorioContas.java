package br.ufrpe.account_manager.dao;

import java.util.ArrayList;

import br.ufrpe.account_manager.negocio.beans.Conta;

public interface IRepositorioContas {
	

	public boolean cadastrar(Conta conta);
	public boolean atualizar(Conta conta);
	public Conta procurar(String id);
	public ArrayList<Conta> listar();
	public boolean remover (String id);
	
}
