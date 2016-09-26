package com.ipartek.formacion.dao.persistencia;

public class Ejemplar extends Libro {

	private int codEjemplar;
	private String editorial;
	private int nPaginas;
	private Usuario usuario;

	public Ejemplar(Usuario usuario) {
		super();
		this.setCodEjemplar(-1);
		this.setEditorial("");
		this.setnPaginas(-1);
		this.setUsuario(usuario);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getCodEjemplar() {
		return codEjemplar;
	}

	public void setCodEjemplar(int codEjemplar) {
		this.codEjemplar = codEjemplar;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getnPaginas() {
		return nPaginas;
	}

	public void setnPaginas(int nPaginas) {
		this.nPaginas = nPaginas;
	}

}
