package br.ufrpe.account_manager.negocio.beans;

public class Categoria {

	private String categoria;
	private String subcategoria;
	private String codigo;
	public Categoria(String categoria, String subcategoria, String codigo) {
		super();
		this.categoria = categoria;
		this.subcategoria = subcategoria;
		this.codigo = codigo;
	}
	
	public Categoria() {
		
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getSubcategoria() {
		return subcategoria;
	}

	public void setSubcategoria(String subcategoria) {
		this.subcategoria = subcategoria;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Categoria [categoria=" + categoria + ", subcategoria=" + subcategoria + ", codigo=" + codigo + "]";
	}
	
	
}
