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

	private ControladorPessoa pessoas;
	private ControladorConta contas;
	private ControladorLogin logins;

	private static SistemaAccountManager instance;

	public SistemaAccountManager() {
		this.contas = new ControladorConta().getInstance();
		this.pessoas = new ControladorPessoa().getInstance();
		this.logins = new ControladorLogin().getInstance();
	}

	public static SistemaAccountManager getInstance() {
		if (instance == null) {
			instance = new SistemaAccountManager();
		}

		return instance;
	}

	/* <<<< PESSOAS >>>> */

	public void cadastrarPessoa(Pessoa pessoa) throws NegocioException {
		this.pessoas.cadastrar(pessoa);
	}

	public void atualizarPessoa(Pessoa pessoa) throws NegocioException {
		this.pessoas.atualizar(pessoa);
	}

	public Pessoa procurarPessoa(String cpf) throws NegocioException {
		return this.pessoas.procurar(cpf);
	}

	public ArrayList<Pessoa> listarPessoas() throws NegocioException {
		return this.pessoas.listar();
	}

	public void removerPessoa(String cpf) throws NegocioException {
		this.pessoas.remover(cpf);
	}

	/* <<<< CONTAS >>>> */

	public void cadastrarConta(Conta conta) throws NegocioException {
		this.contas.cadastrar(conta);
	}

	public void alterarConta(Conta conta) throws NegocioException {
		this.contas.atualizar(conta);
	}

	public Conta procurarConta(String id) throws NegocioException {
		return this.contas.procurar(id);
	}

	public ArrayList<Conta> listarContas() throws NegocioException {
		return this.contas.listar();
	}

	public void removerConta(String id) throws NegocioException {
		this.contas.remover(id);
	}

	/* <<<< CONTATOS >>>> */
	
	
	
	

	/* <<<< LOGIN >>>> */
	public int efetuarLogin(String cpf, String senha) throws NegocioException, Exception {
		return this.logins.efetuarLogin(cpf, senha);

	}
}
