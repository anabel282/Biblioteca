package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.interfaces.LibroDAO;
import com.ipartek.formacion.dao.persistencia.Libro;
import com.ipartek.formacion.service.interfaces.LibroService;

@Service
public class LibroServiceImp implements LibroService{

	@Autowired
	private LibroDAO lDAO;
	
	@Override
	public Libro create(Libro libro) {
		this.lDAO.create(libro);
		return libro;
	}

	@Override
	public void delete(int id) {
		this.lDAO.delete(id);
	}

	@Override
	public Libro update(Libro libro) {
		this.lDAO.update(libro);
		return libro;
	}

	@Override
	public Libro getById(int id) {
		
		return this.lDAO.getById(id);
	}

	@Override
	public List<Libro> getAll() {
		return this.lDAO.getAll();
	}

}
