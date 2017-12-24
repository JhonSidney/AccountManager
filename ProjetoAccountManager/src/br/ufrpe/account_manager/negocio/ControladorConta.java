package br.ufrpe.account_manager.negocio;

import java.util.ArrayList;

import br.ufrpe.account_manager.dao.IRepositorioContas;
import br.ufrpe.account_manager.dao.RepositorioContas;
import br.ufrpe.account_manager.exception.NegocioException;
import br.ufrpe.account_manager.negocio.beans.Conta;

public class ControladorConta {

	private IRepositorioContas<Conta, String> repositorio;
	private static ControladorConta instance;
	
	
	public ControladorConta() {
		this.repositorio = new RepositorioContas();
	}

	public static ControladorConta getInstance() {
		if (instance == null) {
			instance = new ControladorConta();
		}
		return instance;
	}

	public void cadastrar(Conta conta) throws NegocioException {
		if (this.repositorio.existe(conta))
			throw new NegocioException("A conta ja está cadastrada");
		else {
			this.repositorio.cadastrar(conta);
		}
			

	}

	public void remover(Conta conta) throws NegocioException {
		if (this.repositorio.existe(conta))
			this.repositorio.remover(conta);

		else
			throw new NegocioException("Erro ao remover, a conta não está cadastrada");

	}

	public void atualizar(Conta conta) throws NegocioException {
		if (this.repositorio.existe(conta))
			this.repositorio.atualizar(conta);

		else
			throw new NegocioException("Erro, a conta não está cadastrada");

	}

	public ArrayList<Conta> listar() throws NegocioException {
		if (this.repositorio.listar().isEmpty())
			throw new NegocioException("Não existem contas cadastradas");

		else

			return this.repositorio.listar();
	}
}
