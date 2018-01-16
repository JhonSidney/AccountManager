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

public class RepositorioPessoas implements IRepositorioPessoas, Serializable{


	// ATRIBUTOS
	public static final String NOME_ARQUIVOS_BD = "pessoas.dat";
	private ArrayList<Pessoa> pessoas;
	public static RepositorioPessoas instancia;

	private RepositorioPessoas() {
		this.pessoas = new ArrayList<>();
	}

	public static RepositorioPessoas getInstance() {

		if (instancia == null) {
			try{
				instancia =lerDoArquivo();
			} catch (IOException e){
				e.printStackTrace();
			}
		}
		return instancia;
	}

	public static RepositorioPessoas lerDoArquivo() throws IOException {

		RepositorioPessoas instanciaLocal = null;
		File in = new File(NOME_ARQUIVOS_BD);
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
		File out = new File(NOME_ARQUIVOS_BD);
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
	public boolean cadastrar(Pessoa pessoa) {
		this.pessoas.add(pessoa);
		salvarArquivo();
		return true;
	}

	@Override
	public boolean atualizar(Pessoa pessoa) {
		int i = 0;
		for (Pessoa p : this.pessoas) {
			
			if (p.getCpf().equals(pessoa.getCpf())) {
				this.pessoas.set(i, pessoa);
				salvarArquivo();
				return true;
			}
			i++;
		}
		return false;
	}

	
	@Override
	public Pessoa procurar(String cpf) {
		for (Pessoa f : this.pessoas) {
			if (f.getCpf().equals(cpf)) {
				return f;
			}
		}
		return null;
	}

	@Override
	public ArrayList<Pessoa> listar() {

		return this.pessoas;
	}

	public boolean remover(String cpf) {
		int i = 0;
		for (Pessoa f : this.pessoas) {
			
			if (f.getCpf().equals(cpf)) {
				this.pessoas.remove(i);
				salvarArquivo();
				return true;
			}
			i++;
		}

		return false;
	}

	

}
