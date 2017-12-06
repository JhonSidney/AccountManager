package br.ufrpe.account_manager;

import java.util.ArrayList;

import br.ufrpe.account_manager.exception.NegocioException;
import br.ufrpe.account_manager.negocio.ControladorConta;
import br.ufrpe.account_manager.negocio.ControladorLogin;
import br.ufrpe.account_manager.negocio.ControladorPessoa;
import br.ufrpe.account_manager.negocio.beans.Conta;
import br.ufrpe.account_manager.negocio.beans.Pessoa;

public class SistemaAccountManager {

	private ControladorPessoa pessoas;
	private ControladorConta contas;
	private ControladorLogin logins;

	private static SistemaAccountManager instance;

	private SistemaAccountManager() {
		this.pessoas = new ControladorPessoa();
		// this.contas = new ControladorConta.getInstance();
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

	public void removerPessoa(Pessoa pessoa) throws NegocioException {
		this.pessoas.remover(pessoa);
	}

	public void alterarPessoa(Pessoa pessoa) throws NegocioException {
		this.pessoas.atualizar(pessoa);
	}

	// Contas

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
