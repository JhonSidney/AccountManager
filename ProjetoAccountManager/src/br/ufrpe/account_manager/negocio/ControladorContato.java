package br.ufrpe.account_manager.negocio;

import java.util.ArrayList;

import br.ufrpe.account_manager.dao.RepositorioContatos;
import br.ufrpe.account_manager.exception.NegocioException;
import br.ufrpe.account_manager.negocio.beans.Contato;


public class ControladorContato{

	private RepositorioContatos repositorioContato;
	private static ControladorContato instance;

	public ControladorContato() {
		this.repositorioContato = RepositorioContatos.getInstance();
	}

	public static ControladorContato getInstance() {
		if (instance == null) {
			instance = new ControladorContato();
		}
		return instance;
	}

	public void cadastrar(Contato contato) throws NegocioException {
		if (contato != null && !this.existe(contato.getCpf())) {
			this.repositorioContato.cadastrar(contato);
		} else {
			throw new NegocioException("Contato já Existe !");
		}
	}

	public void atualizar(Contato contato) throws NegocioException {
		if (contato != null && this.existe(contato.getCpf())) {
			this.repositorioContato.atualizar(contato);

		} else {
			throw new NegocioException("Contato Não Existe !");
		}
	}

	public Contato procurar(String cpf) throws NegocioException {
		Contato resultado = this.repositorioContato.procurar(cpf);
		return resultado;
	}

	public ArrayList<Contato> listar() {
		return this.repositorioContato.listar();
	}

	private boolean existe(String cpf) {
		ArrayList<Contato> retorno = this.repositorioContato.listar();
		for (Contato contato : retorno) {
			if (contato.getCpf().equals(cpf)) {
				return true;
			}
		}
		return false;
	}

	public void remover(String cpf) throws NegocioException {
		Contato contato = this.repositorioContato.procurar(cpf);

		if (contato != null) {
			this.repositorioContato.remover(cpf);
		} else {
			throw new NegocioException("Contato Não Existe !");
		}
	}


}
