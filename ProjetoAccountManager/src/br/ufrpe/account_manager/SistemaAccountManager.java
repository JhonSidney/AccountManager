package br.ufrpe.account_manager;

import java.util.ArrayList;

import br.ufrpe.account_manager.exception.NegocioException;
import br.ufrpe.account_manager.negocio.ControladorConta;
//import br.ufrpe.account_manager.negocio.ControladorContatos;
import br.ufrpe.account_manager.negocio.ControladorLogin;
import br.ufrpe.account_manager.negocio.ControladorPessoa;
import br.ufrpe.account_manager.negocio.beans.Conta;
import br.ufrpe.account_manager.negocio.beans.Pessoa;

public class SistemaAccountManager {

//	private ControladorContatos contatos;
	private ControladorPessoa pessoas;
	private ControladorConta contas;
	private ControladorLogin logins;

	private static SistemaAccountManager instance;

	public SistemaAccountManager() {
		//this.contatos = new ControladorContatos().getInstance();
		//this.contas = new ControladorConta.getInstance();
		this.pessoas = new ControladorPessoa().getInstance();
		this.logins = new ControladorLogin().getInstance();
	}

	public static SistemaAccountManager getInstance() {
		if (instance == null) {
			instance = new SistemaAccountManager();
		}

		return instance;
	}

	// Pessoa

	public void cadastrarPessoa(Pessoa pessoa) throws NegocioException {
		this.pessoas.cadastrar(pessoa);
	}

	public void removerPessoa(String cpf) throws NegocioException {
		// public void removerPessoa(Pessoa pessoa) throws NegocioException {
		// this.pessoas.remover(pessoa);
		this.pessoas.remover(cpf);
	}

	public void alterarPessoa(Pessoa pessoa) throws NegocioException {
		this.pessoas.atualizar(pessoa);
	}

	public void cadastrarConta(Conta conta) throws NegocioException {
		this.contas.cadastrar(conta);
	}

	public void removerConta(Conta conta) throws NegocioException {
		this.contas.remover(conta);
	}

	public void alterarConta(Conta conta) throws NegocioException {
		this.contas.atualizar(conta);
	}

	public ArrayList<Conta> listarContas() throws NegocioException {
		return this.contas.listar();
	}

	public int efetuarLogin(String cpf, String senha) throws NegocioException {
		return this.logins.efetuarLogin(cpf, senha);

	}
}
