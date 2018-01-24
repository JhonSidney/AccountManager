package br.ufrpe.account_manager.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import br.ufrpe.account_manager.negocio.beans.Conta;


public class RepositorioContas implements IRepositorioContas, Serializable {

	
	// ATRIBUTOS
		public static final String NOME_ARQUIVOS_BD = "contas.dat";
		private ArrayList<Conta> contas;
		public static RepositorioContas instancia;

		private RepositorioContas() {
			this.contas = new ArrayList<>();
		}

		public static RepositorioContas getInstance() {

			if (instancia == null) {
				try{
					instancia =lerDoArquivo();
				} catch (IOException e){
					e.printStackTrace();
				}
			}
			return instancia;
		}

		public static RepositorioContas lerDoArquivo() throws IOException {

			RepositorioContas instanciaLocal = null;
			File in = new File(NOME_ARQUIVOS_BD);
			FileInputStream fis = null;
			ObjectInputStream ois = null;

			try {
				fis = new FileInputStream(in);
				ois = new ObjectInputStream(fis);
				Object o = ois.readObject();
				instanciaLocal = (RepositorioContas) o;
			} catch (Exception e) {
				instanciaLocal = new RepositorioContas();
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
		public boolean cadastrar(Conta conta) {
			this.contas.add(conta);
			salvarArquivo();
			return true;
		}

		@Override
		public boolean atualizar(Conta conta) {
			int i = 0;
			for (Conta contas : this.contas) {
				
				if (contas.getId().equals(contas.getId())) {
					this.contas.set(i, conta);
					salvarArquivo();
					return true;
				}
				i++;
			}
			return false;
		}

		@Override
		public Conta procurar(String id) {
			for (Conta c : this.contas) {
				if (c.getId().equals(id)) {
					return c;
				}
			}
			return null;
		}

		@Override
		public ArrayList<Conta> listar() {

			return this.contas;
		}

		public boolean remover(String id) {
			int i = 0;
			for (Conta c : this.contas) {
				
				if (c.getId().equals(id)) {
					this.contas.remove(i);
					salvarArquivo();
					return true;
				}
				i++;
			}

			return false;
		}

		
	
	
}


