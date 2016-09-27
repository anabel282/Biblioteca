package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.interfaces.EjemplarDAO;
import com.ipartek.formacion.dao.persistencia.Ejemplar;
import com.ipartek.formacion.dao.persistencia.Libro;
import com.ipartek.formacion.service.interfaces.EjemplarService;

@Service
public class EjemplarServiceImp implements EjemplarService{

	@Autowired
	private EjemplarDAO eDao;

	@Override
	public Ejemplar create(Ejemplar ejemplar) {

		this.eDao.create(ejemplar);
		return ejemplar;
	}

	@Override
	public void delete(int id) {

		this.eDao.delete(id);
	}

	@Override
	public Ejemplar update(Ejemplar ejemplar) {

		this.eDao.update(ejemplar);
		return ejemplar;
	}

	@Override
	public List<Libro> findLibro(Libro libro) {

		return this.eDao.findLibro(libro);
	}

	@Override
	public List<Libro> getAll() {

		return this.eDao.getAll();
	}
	
	
}
