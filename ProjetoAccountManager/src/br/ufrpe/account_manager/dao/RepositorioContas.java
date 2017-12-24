package br.ufrpe.account_manager.dao;

import java.util.ArrayList;

import br.ufrpe.account_manager.negocio.beans.Conta;

public class RepositorioContas implements IRepositorioContas<Conta,String> {

	private ArrayList<Conta> contas;
	
	
	private int procurarIndice(Conta conta)
	{
		int indice = -1;

		for (int i = 0; i < this.contas.size(); i++) 
		{
			if (this.contas.get(i).equals(conta)) 
			{
				indice = i;
			}
		}
		return indice;
}
	

	@Override
	public void cadastrar(Conta conta) {
		
		this.contas.add(conta);
	}

	@Override
	public void remover(Conta conta) {

		this.contas.remove(conta);
	}


	@Override
	public ArrayList<Conta> listar() {
		
		return this.contas;
	}


	@Override
	public void atualizar(Conta conta) {
		
		int indice = this.procurarIndice(conta);
		this.contas.set(indice, conta);
		
	}

	public Conta procurar(String id) {

		for (Conta c : this.contas) {
			if (c.getId().equals(id)) {
				return c;
			}
		}
		return null;
	}
	
	@Override
	public boolean existe(Conta conta) {

		boolean resultado = false;
		for(int i =0; i<this.contas.size(); i++) {
			if(this.contas.get(i).equals(conta)) {
				return true;
			}
		}
		return resultado;
	}
	
	/*
	public Conta existe(String nome) {
		
		Conta conta = null;
		for(int i =0; i<this.contas.size(); i++) {
			if(contas.get(i).getNome().equals(nome)) {
				conta = contas.get(i);
			}
		}
		return conta;
		
	}

	@Override
	public boolean existeNome(String nome) {

		boolean resultado = false;
		for(int i =0; i<this.contas.size();i++) {
			if(this.contas.get(i).equals(nome)) {
				return resultado;
			}
		}
		return false;
	}
*/
}
