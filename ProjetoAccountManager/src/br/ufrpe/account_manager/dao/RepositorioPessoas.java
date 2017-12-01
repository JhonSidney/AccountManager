package br.ufrpe.account_manager.dao;

import java.util.ArrayList;

import br.ufrpe.account_manager.negocio.beans.Conta;
import br.ufrpe.account_manager.negocio.beans.Pessoa;

public class RepositorioPessoas implements IRepositorio<Pessoa, String>{

	private ArrayList<Pessoa> pessoas;
	
	private int procurarIndice(Pessoa pessoa)
	{
		int indice = -1;

		for (int i = 0; i < this.pessoas.size(); i++) 
		{
			if (this.pessoas.get(i).equals(pessoa)) 
			{
				indice = i;
			}
		}
		return indice;
}
	
	@Override
	public void cadastrar(Pessoa pessoa) {
		
		this.pessoas.add(pessoa);
	}

	@Override
	public void remover(Pessoa pessoa) {

		this.pessoas.remove(pessoa);
	}

	@Override
	public ArrayList<Pessoa> listar() {
		
		return this.pessoas;
	}
	
	@Override
	public void atualizar(Pessoa pessoa) {

		int indice = this.procurarIndice(pessoa);
		this.pessoas.set(indice, pessoa);
	}


	@Override
	public Pessoa existe(Pessoa pessoa) {
		
		Pessoa resultado = null;
		for(int i=0; i<this.pessoas.size();i++) {
			if(this.pessoas.get(i).equals(pessoa)) {
				return resultado;
			}
		}
		
		return null;
	}
	
	public Pessoa existe(String nome) {
		
		Pessoa pessoa = null;
		for(int i=0; i<this.pessoas.size();i++) {
			if(pessoas.get(i).getNome().equals(pessoa)) {
				pessoa = pessoas.get(i);
			}
		}
		
		return pessoa;
	}

	@Override
	public boolean existeNome(String cpf) {
		
		boolean resultado = false;
		for(int i=0;i<this.pessoas.size(); i++) {
			if(this.pessoas.get(i).getCpf().equals(cpf)) {
				return resultado;
			}
		}
		
		return false;
	}

}
