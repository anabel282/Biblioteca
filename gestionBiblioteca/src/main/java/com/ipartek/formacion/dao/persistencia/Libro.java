package com.ipartek.formacion.dao.persistencia;

import java.util.List;

import javax.validation.constraints.Size;

public class Libro {

	private int codLibro;
	private String titulo;
	@Size(min = 5, message = "El autor tiene que tener minimo 5 caracteres")
	private String nombreApellidos;
	private String ISBN;
	private List<Ejemplar> ejemplares;

	public Libro() {
		super();
		this.setCodLibro(-1);
		this.setISBN("");
		this.setNombreApellidos("");
		this.setTitulo("");
	}

	
	public void addEjemplares(Ejemplar ejemplar){
		this.ejemplares.add(ejemplar);
	}
	
	public List<Ejemplar> getEjemplares() {
		return ejemplares;
	}

	public void setEjemplares(List<Ejemplar> ejemplares) {
		this.ejemplares = ejemplares;
	}

	public int getCodLibro() {
		return codLibro;
	}

	public void setCodLibro(int codLibro) {
		this.codLibro = codLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNombreApellidos() {
		return nombreApellidos;
	}

	public void setNombreApellidos(String nombreApellidos) {
		this.nombreApellidos = nombreApellidos;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

}
