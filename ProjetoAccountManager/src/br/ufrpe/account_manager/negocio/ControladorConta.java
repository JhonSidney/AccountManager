package br.ufrpe.account_manager.negocio;

import java.util.ArrayList;

import br.ufrpe.account_manager.dao.IRepositorio;
import br.ufrpe.account_manager.dao.RepositorioContas;
import br.ufrpe.account_manager.exception.NegocioException;
import br.ufrpe.account_manager.negocio.beans.Conta;

public class ControladorConta {

	private IRepositorio<Conta, String> repositorio;
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
		if (this.repositorio.existe(conta) == null)
			this.repositorio.cadastrar(conta);

		else
			throw new NegocioException("A conta ja está cadastrada");

	}

	public void remover(Conta conta) throws NegocioException {
		if (this.repositorio.existeNome(conta.getNome()))
			this.repositorio.remover(conta);

		else
			throw new NegocioException("Erro ao remover, a conta não está cadastrada");

	}

	public void atualizar(Conta conta) throws NegocioException {
		if (this.repositorio.existeNome(conta.getNome()))
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
