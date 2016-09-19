package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.persistencia.Ejemplar;

public interface EjemplarService {
	
	public Ejemplar create(Ejemplar ejemplar);
	
	public void delete(int id);
	
	public Ejemplar update(Ejemplar ejemplar);
	
	public Ejemplar getById(int id);
	
	public List<Ejemplar> getAll();

}
