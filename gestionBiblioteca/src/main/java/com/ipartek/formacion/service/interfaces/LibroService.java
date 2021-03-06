package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.persistencia.Libro;

public interface LibroService {

	public Libro create(Libro libro);
	
	public void delete(int id);
	
	public Libro update(Libro libro);
	
	public Libro getById(int id);
	
	public List<Libro> getAll();
}
