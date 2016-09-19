package com.ipartek.formacion.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.dao.interfaces.EjemplarDAO;
import com.ipartek.formacion.dao.persistencia.Ejemplar;

@Repository
public class EjemplarDAOImp implements EjemplarDAO{

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	@Override
	public void SetterDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Ejemplar create(Ejemplar ejemplar) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Ejemplar update(Ejemplar ejemplar) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Ejemplar getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Ejemplar> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
