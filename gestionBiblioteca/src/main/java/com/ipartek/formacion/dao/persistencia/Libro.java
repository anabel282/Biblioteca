package com.ipartek.formacion.dao.persistencia;

import javax.validation.constraints.Size;

public class Libro {

  private int codigo;
  private String titulo;
  @Size(min = 5, message = "El autor tiene que tener minimo 5 caracteres")
  private String nombreApellidos;
  private String ISBN;

  public Libro() {
    super();
    this.setCodigo(-1);
    this.setISBN("");
    this.setNombreApellidos("");
    this.setTitulo("");
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
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
