package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.persistencia.Usuario;

public interface UsuarioService {

	public Usuario create(Usuario usuario);
	
	public void delete(int id);
	
	public Usuario update(Usuario usuario);
	
	public Usuario getById(int id);
	
	public List<Usuario> getAll();
}
