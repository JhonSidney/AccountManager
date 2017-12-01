package br.ufrpe.account_manager;

import java.util.ArrayList;

import br.ufrpe.account_manager.exception.NegocioException;
import br.ufrpe.account_manager.negocio.ControladorConta;
import br.ufrpe.account_manager.negocio.ControladorPessoa;
import br.ufrpe.account_manager.negocio.beans.Conta;
import br.ufrpe.account_manager.negocio.beans.Pessoa;

public class Fachada {

	private ControladorPessoa pessoas;
	private ControladorConta contas;
	
	private static Fachada instance;
	
	private Fachada() {
		this.pessoas = new ControladorPessoa();
		this.contas = new ControladorConta();
	}
	
	public static Fachada getInstance() {
		if(instance==null) {
			instance = new Fachada();
		}
		
		return instance;
	}
	
	public void cadastrarConta(Conta conta) throws NegocioException{
		this.contas.cadastrar(conta);
	}
	
	public void cadastrarPessoa(Pessoa pessoa) throws NegocioException{
		this.pessoas.cadastrar(pessoa);
	}
	
	public void removerConta(Conta conta) throws NegocioException{
		this.contas.remover(conta);
	}
	
	public void removerPessoa(Pessoa pessoa) throws NegocioException{
		this.pessoas.remover(pessoa);
	}
	
	public void alterarConta(Conta conta) throws NegocioException{
		this.contas.atualizar(conta);
	}
	
	public void alterarPessoa(Pessoa pessoa) throws NegocioException{
		this.pessoas.atualizar(pessoa);
	}
	
	public ArrayList<Conta> listarContas() throws NegocioException{
		return this.contas.listar();
	}
	
}
