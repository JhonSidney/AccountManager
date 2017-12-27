package br.ufrpe.account_manager.negocio;

import br.ufrpe.account_manager.dao.IRepositorioPessoas;
import br.ufrpe.account_manager.dao.RepositorioPessoas;
import br.ufrpe.account_manager.exception.NegocioException;
import br.ufrpe.account_manager.negocio.beans.Pessoa;

public class ControladorPessoa {
	

	private IRepositorioPessoas repositorio;
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
		 if(pessoa != null && !this.existeCpf(pessoa.getCpf()))
		//if (this.repositorio.existe(pessoa) == null)
			this.repositorio.cadastrar(pessoa);
		else
			throw new NegocioException("A pessoa já está cadastrada");
	}

	
	public void remover(String cpf) throws NegocioException{	
	//public void remover(Pessoa pessoa) throws NegocioException {
		//if (this.repositorio.existeCpf(pessoa.getCpf()))
		Pessoa pessoa = this.repositorio.procurar(cpf);
		if(pessoa != null)
		this.repositorio.remover(pessoa);
		else
			throw new NegocioException("Erro ao remover, a pessoa não está cadastrada");
	}

	public void atualizar(Pessoa pessoa) throws NegocioException {
		if (pessoa != null && this.repositorio.existeCpf(pessoa.getCpf()))
			this.repositorio.atualizar(pessoa);
		else
			throw new NegocioException("Erro, a pessoa não está cadastrada");
	}

	public Pessoa procurar(String cpf) throws NegocioException {
		Pessoa resultado = this.repositorio.procurar(cpf);
		return resultado;
		
	}

	//acima implementado
	private  boolean existeCpf(String cpf) {
		boolean resultado = this.repositorio.existeCpf(cpf);
		return resultado;
	}

	/*protected Pessoa existe(Pessoa pessoa) {
		Pessoa resultado = this.repositorio.existe(pessoa);
		return resultado;
	}
	
	*/

}
