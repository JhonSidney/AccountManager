package br.ufrpe.account_manager.negocio;

import br.ufrpe.account_manager.dao.IRepositorio;
import br.ufrpe.account_manager.dao.RepositorioPessoas;
import br.ufrpe.account_manager.exception.NegocioException;
import br.ufrpe.account_manager.negocio.beans.Pessoa;

public class ControladorPessoa {

	private IRepositorio<Pessoa, String> repositorio;
	private static ControladorPessoa instance;

	public ControladorPessoa() {
		this.repositorio = new RepositorioPessoas();
	}

	public static ControladorPessoa getInstance() {
		if (instance == null) {
			instance = new ControladorPessoa();
		}
		return instance;
	}

	public void cadastrar(Pessoa pessoa) throws NegocioException {
		if (this.repositorio.existe(pessoa) == null)
			this.repositorio.cadastrar(pessoa);
		else
			throw new NegocioException("A pessoa j� est� cadastrada");
	}

	public void remover(Pessoa pessoa) throws NegocioException {
		if (this.repositorio.existeNome(pessoa.getCpf()))
			this.repositorio.remover(pessoa);
		else
			throw new NegocioException("Erro ao remover, a pessoa n�o est� cadastrada");
	}

	public void atualizar(Pessoa pessoa) throws NegocioException {
		if (this.repositorio.existeNome(pessoa.getCpf()))
			this.repositorio.atualizar(pessoa);
		else
			throw new NegocioException("Erro, a pessoa n�o est� cadastrada");
	}

	public boolean existeNome(String cpf) {
		boolean resultado = this.repositorio.existeNome(cpf);
		return resultado;
	}

	public Pessoa existe(Pessoa pessoa) {
		Pessoa resultado = this.repositorio.existe(pessoa);
		return resultado;
	}

	//FALTA O METODO DE PROCURAR POR NOME
}
