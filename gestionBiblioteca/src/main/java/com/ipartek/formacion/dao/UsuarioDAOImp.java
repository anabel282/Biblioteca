package com.ipartek.formacion.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.dao.Mappers.UsuarioMapper;
import com.ipartek.formacion.dao.interfaces.UsuarioDAO;
import com.ipartek.formacion.dao.persistencia.Usuario;

@Repository
public class UsuarioDAOImp implements UsuarioDAO {

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	@Override
	public void SetterDataSource(DataSource dataSource) {

		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Usuario create(Usuario usuario) {

		String SQL = "INSERT INTO usuario (nombre, apellidos, fNacimiento, email, pass) VALUE (?,?,?,?,?)";
		this.jdbcTemplate.update(SQL, new Object[] { usuario.getNombre(), usuario.getApellidos(),
				usuario.getfNacimiento(), usuario.getEmail(), usuario.getPass() });
		return usuario;
	}

	@Override
	public void delete(int id) {

		String SQL = "DELETE FROM usuario WHERE codigo=?";
		this.jdbcTemplate.update(SQL, new Object[] { id });

	}

	@Override
	public Usuario update(Usuario usuario) {

		String SQL = "UPDATE usuario SET nombre=?, apellidos=?, fNacimiento=?, email=?, pass=? WHERE codigo=?";
		this.jdbcTemplate.update(SQL, new Object[] { usuario.getNombre(), usuario.getApellidos(),
				usuario.getfNacimiento(), usuario.getEmail(), usuario.getPass(), usuario.getCodigo() });
		return usuario;
	}

	@Override
	public Usuario getById(int id) {

		String SQL = "SELECT nombre, apellidos, fNacimiento, email, pass FROM usuario WHERE codigo=? ";
		Usuario usuario = this.jdbcTemplate.queryForObject(SQL, new Object[] { id }, new UsuarioMapper());
		return usuario;
	}

	@Override
	public List<Usuario> getAll() {

		String SQL = "SELECT nombre, apellidos, fNacimiento, email, pass FROM usuario";
		List<Usuario> usuarios = this.jdbcTemplate.query(SQL, new UsuarioMapper());
		return usuarios;
	}

}
