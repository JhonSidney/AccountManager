package br.ufrpe.account_manager.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import br.ufrpe.account_manager.negocio.beans.Contato;



public class RepositorioContatos implements IRepositorioContatos, Serializable{


	// ATRIBUTOS
	public static final String NOME_ARQUIVOS_BD = "pessoas.dat";
	private ArrayList<Contato> contatos;
	public static RepositorioContatos instancia;

	private RepositorioContatos() {
		this.contatos = new ArrayList<>();
	}

	public static RepositorioContatos getInstance() {

		if (instancia == null) {
			try{
				instancia =lerDoArquivo();
			} catch (IOException e){
				e.printStackTrace();
			}
		}
		return instancia;
	}

	public static RepositorioContatos lerDoArquivo() throws IOException {

		RepositorioContatos instanciaLocal = null;
		File in = new File(NOME_ARQUIVOS_BD);
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioContatos) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioContatos();
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
	public boolean cadastrar(Contato contato) {
		this.contatos.add(contato);
		salvarArquivo();
		return true;
	}

	@Override
	public boolean atualizar(Contato contato) {
		int i = 0;
		for (Contato p : this.contatos) {
			
			if (p.getCpf().equals(contato.getCpf())) {
				this.contatos.set(i, contato);
				salvarArquivo();
				return true;
			}
			i++;
		}
		return false;
	}

	@Override
	public Contato procurar(String cpf) {
		for (Contato f : this.contatos) {
			if (f.getCpf().equals(cpf)) {
				return f;
			}
		}
		return null;
	}

	@Override
	public ArrayList<Contato> listar() {

		return this.contatos;
	}

	public boolean remover(String cpf) {
		int i = 0;
		for (Contato f : this.contatos) {
			
			if (f.getCpf().equals(cpf)) {
				this.contatos.remove(i);
				salvarArquivo();
				return true;
			}
			i++;
		}

		return false;
	}

	

}
