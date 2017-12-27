package br.ufrpe.account_manager.negocio;

import java.util.ArrayList;

import br.ufrpe.account_manager.dao.IRepositorioContatos;
import br.ufrpe.account_manager.dao.RepositorioContatos;
import br.ufrpe.account_manager.exception.NegocioException;
import br.ufrpe.account_manager.negocio.beans.Conta;
import br.ufrpe.account_manager.negocio.beans.Contatos;

public class ControladorContatos {

	private IRepositorioContatos repositorio;
	private static ControladorContatos instance;
	
	public ControladorContatos(){
		this.repositorio = new RepositorioContatos();
		
	}
	
	public static ControladorContatos getInstance() {
		if(instance == null) {
			instance = new  ControladorContatos();
		}
		return instance;
	}
	
	public void cadastrar(Contatos contato) throws NegocioException {
		if (this.repositorio.existe(contato))
			throw new NegocioException("O contato já foi adicionado a sua lista");
		else {
			this.repositorio.cadastrar(contato);
		}
			
	}

	public void remover(Contatos contato) throws NegocioException {
		if (this.repositorio.existe(contato))
			this.repositorio.remover(contato);

		else
			throw new NegocioException("Erro ao remover, o contato não faz parte da sua lista!");

	}

	public void atualizar(Contatos contato) throws NegocioException {
		if (this.repositorio.existe(contato))
			this.repositorio.atualizar(contato);

		else
			throw new NegocioException("Erro, o contato não está cadastrado na sua lista!");

	}

	public ArrayList<Contatos> listar() throws NegocioException {
		if (this.repositorio.listar().isEmpty())
			throw new NegocioException("Não existem contas cadastradas");

		else

			return this.repositorio.listar();
	}
}

