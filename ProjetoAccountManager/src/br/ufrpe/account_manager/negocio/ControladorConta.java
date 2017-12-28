package br.ufrpe.account_manager.negocio;

import java.util.ArrayList;

import br.ufrpe.account_manager.dao.RepositorioContas;
import br.ufrpe.account_manager.exception.NegocioException;
import br.ufrpe.account_manager.negocio.beans.Conta		;

public class ControladorConta {

	private RepositorioContas repositorioConta;
	private static ControladorConta instance;

	public ControladorConta() {
		this.repositorioConta = RepositorioContas.getInstance();
	}

	public static ControladorConta getInstance() {
		if (instance == null) {
			instance = new ControladorConta();
		}
		return instance;
	}

	public void cadastrar(Conta Conta) throws NegocioException {
		if (Conta != null && !this.existe(Conta.getId())) {
			this.repositorioConta.cadastrar(Conta);
		} else {
			
		}
	}

	public void atualizar(Conta Conta) throws NegocioException {
		if (Conta != null && this.existe(Conta.getId())) {
			this.repositorioConta.atualizar(Conta);

		} else {
			throw new NegocioException("Conta Não Existe !");
		}
	}

	public Conta procurar(String id) throws NegocioException {
		Conta resultado = this.repositorioConta.procurar(id);
		return resultado;
	}

	public ArrayList<Conta> listar() {
		return this.repositorioConta.listar();
	}

	private boolean existe(String id) {
		ArrayList<Conta> retorno = this.repositorioConta.listar();
		for (Conta Conta : retorno) {
			if (Conta.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}

	public void remover(String id) throws NegocioException {
		Conta Conta = this.repositorioConta.procurar(id);

		if (Conta != null) {
			this.repositorioConta.remover(id);
		} else {
			throw new NegocioException("Conta Não Existe !");
		}
	}


}
