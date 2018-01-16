package br.ufrpe.account_manager.negocio;

import java.util.ArrayList;

import br.ufrpe.account_manager.dao.IRepositorioContatos;
import br.ufrpe.account_manager.dao.RepositorioContatos;
import br.ufrpe.account_manager.exception.NegocioException;
import br.ufrpe.account_manager.negocio.beans.Contato;
import br.ufrpe.account_manager.negocio.beans.Pessoa;

public class ControladorContatos {

	private RepositorioContatos repositorioContato;
	private static ControladorContatos instance;
	
	public ControladorContatos(){
		this.repositorioContato = new RepositorioContatos();
		
	}
	
	public static ControladorContatos getInstance() {
		if(instance == null) {
			instance = new  ControladorContatos();
		}
		return instance;
	}
	
	public void cadastrar(Contato contato) throws NegocioException {
		if (this.repositorioContato.existe(contato))
			throw new NegocioException("O contato j� foi adicionado a sua lista");
		else {
			this.repositorioContato.cadastrar(contato);
		}
			
	}
	
	public Contato procurar(String cpf) throws NegocioException {
		Contato resultado = this.repositorioContato.procurar(cpf);
		return resultado;
	}

	public void atualizar(Contato contato) throws NegocioException {
		if (this.repositorioContato.existe(contato))
			this.repositorioContato.atualizar(contato);

		else
			throw new NegocioException("Erro, o contato n�o est� cadastrado na sua lista!");

	}

	public void remover(Contato contato) throws NegocioException {
		if (this.repositorioContato.existe(contato))
			this.repositorioContato.remover(contato);

		else
			throw new NegocioException("Erro ao remover, o contato n�o faz parte da sua lista!");

	}

	public ArrayList<Contato> listar() throws NegocioException {
		if (this.repositorioContato.listar().isEmpty())
			throw new NegocioException("N�o existem contas cadastradas");

		else

			return this.repositorioContato.listar();
	}
}


