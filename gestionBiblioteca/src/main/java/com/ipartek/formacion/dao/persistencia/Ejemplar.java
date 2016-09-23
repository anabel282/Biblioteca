package com.ipartek.formacion.dao.persistencia;

public class Ejemplar extends Libro {

	private int codigo;
	private String editorial;
	private int nPaginas;
	private int idLibro;
	private int disponible;
	private int nEjemplares;

	public Ejemplar() {
		super();
		this.setCodigo(-1);
		this.setEditorial("");
		this.setnPaginas(-1);
		this.setIdLibro(-1);
		this.setDisponible(0);
		this.setnEjemplares(0);
	}

	
	
	public int getnEjemplares() {
		return nEjemplares;
	}



	public void setnEjemplares(int nEjemplares) {
		this.nEjemplares = nEjemplares;
	}



	public int getDisponible() {
		return disponible;
	}

	public void setDisponible(int disponible) {
		this.disponible = disponible;
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
