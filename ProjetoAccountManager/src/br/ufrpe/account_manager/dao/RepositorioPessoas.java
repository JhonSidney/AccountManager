package br.ufrpe.account_manager.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import br.ufrpe.account_manager.negocio.beans.Pessoa;


public class RepositorioPessoas implements IRepositorioPessoas<Pessoa, String>, Serializable {

	private static final String NOME_ARQUIVO_BD = "pessoas.dat";
	private ArrayList<Pessoa> pessoas;
	public static RepositorioPessoas instancia;

	public RepositorioPessoas() {
		pessoas = new ArrayList<>();
	}

	public static RepositorioPessoas getInstance() {
		if (instancia == null) {
			try {
				instancia = lerDoArquivo();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return instancia;
	}

	public static RepositorioPessoas lerDoArquivo() throws IOException {
		
		RepositorioPessoas instanciaLocal = null;
		File in = new File(NOME_ARQUIVO_BD);
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioPessoas) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioPessoas();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					/* Silence exception */
				}
			}
		}
		return instanciaLocal;
	}
	
	public void salvarArquivo() {
		if (instancia == null) {
			return;
		}
		File out = new File(NOME_ARQUIVO_BD);
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(out);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(instancia);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					/* Silent */}
			}
		}
	}


	@Override
	public void cadastrar(Pessoa pessoa) {

		this.pessoas.add(pessoa);
	}

	@Override
	public void remover(Pessoa pessoa) {

		this.pessoas.remove(pessoa);
	}

	@Override
	public ArrayList<Pessoa> listar() {

		return this.pessoas;
	}

	@Override
	public void atualizar(Pessoa pessoa) {

		int indice = this.procurarIndice(pessoa);
		this.pessoas.set(indice, pessoa);
	}

	public Pessoa procurar(String cpf) {

		for (Pessoa p : this.pessoas) {
			if (p.getCpf().equals(cpf)) {
				return p;
			}
		}
		return null;
	}
	
	//implementado acima 
	
	@Override
	public Pessoa existe(Pessoa pessoa) {

		Pessoa resultado = null;
		for (int i = 0; i < this.pessoas.size(); i++) {
			if (this.pessoas.get(i).equals(pessoa)) {
				return resultado;
			}
		}

		return null;
	}

	public Pessoa existe(String nome) {

		Pessoa pessoa = null;
		for (int i = 0; i < this.pessoas.size(); i++) {
			if (pessoas.get(i).getNome().equals(pessoa)) {
				pessoa = pessoas.get(i);
			}
		}

		return pessoa;
	}

	@Override
	public boolean existeNome(String cpf) {

		boolean resultado = false;
		for (int i = 0; i < this.pessoas.size(); i++) {
			if (this.pessoas.get(i).getCpf().equals(cpf)) {
				return resultado;
			}
		}

		return false;
	}

	private int procurarIndice(Pessoa pessoa) {
		int indice = -1;

		for (int i = 0; i < this.pessoas.size(); i++) {
			if (this.pessoas.get(i).equals(pessoa)) {
				indice = i;
			}
		}
		return indice;
	}

}
