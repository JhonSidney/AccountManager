package br.ufrpe.account_manager.dao;

import java.util.ArrayList;

import br.ufrpe.account_manager.negocio.beans.Conta;

public interface IRepositorioContas<T,K> {
	

	public void cadastrar(Conta conta);
	public void remover (Conta conta);
	public ArrayList<Conta> listar();
	public void atualizar(Conta conta);
	public Conta existe(Conta conta);
	public Conta existe(String nome);
	public boolean existeNome(String nome);
	
	
	
	
	
}