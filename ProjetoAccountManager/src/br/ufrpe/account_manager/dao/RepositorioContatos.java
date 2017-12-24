package br.ufrpe.account_manager.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import br.ufrpe.account_manager.negocio.beans.Contatos;

public class RepositorioContatos {

	private static final String NOME_ARQUIVO_BD = "contato.dat";
	private ArrayList<Contatos> contato;
	public static RepositorioContatos instancia;

	public RepositorioContatos() {
		contato = new ArrayList<>();
	}

	public static RepositorioContatos getInstance() {
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

	public static RepositorioContatos lerDoArquivo() throws IOException {
		
		RepositorioContatos instanciaLocal = null;
		File in = new File(NOME_ARQUIVO_BD);
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


	public void cadastrar(Contatos c1) {

		this.contato.add(c1);
	}

	public void remover(Contatos c1) {

		this.contato.remove(c1);
	}

	public ArrayList<Contatos> listar() {

		return this.contato;
	}

	public void atualizar(Contatos c1) {
		
		int indice = this.procurarIndice(c1);
		this.contato.set(indice, c1);
	}

	public Contatos procurar(String cpf) {

		for (Contatos c : this.contato) {
			if (c.getCpf().equals(cpf)) {
				return c;
			}
		}
		return null;
	}
	
	private int procurarIndice(Contatos c1) {
		int indice = -1;

		for (int i = 0; i < this.contato.size(); i++) {
			if (this.contato.get(i).equals(c1)) {
				indice = i;
			}
		}
		return indice;
	}

	
}
