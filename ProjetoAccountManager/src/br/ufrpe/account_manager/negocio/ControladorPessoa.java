package br.ufrpe.account_manager.negocio;

import java.util.ArrayList;

import br.ufrpe.account_manager.dao.RepositorioPessoas;
import br.ufrpe.account_manager.exception.NegocioException;
import br.ufrpe.account_manager.negocio.beans.Pessoa;

public class ControladorPessoa {

	private RepositorioPessoas repositorioPessoa;
	private static ControladorPessoa instance;

	public ControladorPessoa() {
		this.repositorioPessoa = RepositorioPessoas.getInstance();
	}

	public static ControladorPessoa getInstance() {
		if (instance == null) {
			instance = new ControladorPessoa();
		}
		return instance;
	}

	public void cadastrar(Pessoa pessoa) throws NegocioException {
		if (pessoa != null && !this.existe(pessoa.getCpf())) {
			this.repositorioPessoa.cadastrar(pessoa);
		} else {
			
		}
	}

	public void atualizar(Pessoa pessoa) throws NegocioException {
		if (pessoa != null && this.existe(pessoa.getCpf())) {
			this.repositorioPessoa.atualizar(pessoa);

		} else {
			throw new NegocioException("Funcionario Não Existe !");
		}
	}

	public Pessoa procurar(String cpf) throws NegocioException {
		Pessoa resultado = this.repositorioPessoa.procurar(cpf);
		return resultado;
	}

	public ArrayList<Pessoa> listar() {
		return this.repositorioPessoa.listar();
	}

	private boolean existe(String cpf) {
		ArrayList<Pessoa> retorno = this.repositorioPessoa.listar();
		for (Pessoa pessoa : retorno) {
			if (pessoa.getCpf().equals(cpf)) {
				return true;
			}
		}
		return false;
	}

	public void remover(String cpf) throws NegocioException {
		Pessoa pessoa = this.repositorioPessoa.procurar(cpf);

		if (pessoa != null) {
			this.repositorioPessoa.remover(cpf);
		} else {
			throw new NegocioException("Funcionario Não Existe !");
		}
	}


}
