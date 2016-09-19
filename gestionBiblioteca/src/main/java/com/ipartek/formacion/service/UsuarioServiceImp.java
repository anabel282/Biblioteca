package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.interfaces.UsuarioDAO;
import com.ipartek.formacion.dao.persistencia.Usuario;
import com.ipartek.formacion.service.interfaces.UsuarioService;

@Service
public class UsuarioServiceImp implements UsuarioService{

	@Autowired
	private UsuarioDAO uDao;

	@Override
	public Usuario create(Usuario usuario) {
		this.uDao.create(usuario);
		return usuario;
	}

	@Override
	public void delete(int id) {

		this.uDao.delete(id);
	}

	@Override
	public Usuario update(Usuario usuario) {
		this.uDao.update(usuario);
		return usuario;
	}

	@Override
	public Usuario getById(int id) {
		return this.uDao.getById(id);
	}

	@Override
	public List<Usuario> getAll() {
		return this.uDao.getAll();
	}
	
	
}
