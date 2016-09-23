package com.ipartek.formacion.dao.persistencia;

import java.util.Date;

public class Usuario {

	private int codigo;
	private String nombre;
	private String apellidos;
	private Date fNacimiento;
	private String pass;
	private String email;
	private int idEjemplar;

	public Usuario() {

		this.setApellidos("");
		this.setCodigo(-1);
		this.setEmail("");
		this.setNombre("");
		this.setPass("");
		this.setfNacimiento(null);
		this.setIdEjemplar(-1);

	}

	public int getIdEjemplar() {
		return idEjemplar;
	}

	public void setIdEjemplar(int idEjemplar) {
		this.idEjemplar = idEjemplar;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getfNacimiento() {
		return fNacimiento;
	}

	public void setfNacimiento(Date fNacimiento) {
		this.fNacimiento = fNacimiento;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
