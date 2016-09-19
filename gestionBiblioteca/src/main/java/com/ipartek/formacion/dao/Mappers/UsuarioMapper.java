package com.ipartek.formacion.dao.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.dao.persistencia.Usuario;

public class UsuarioMapper implements RowMapper<Usuario> {

  @Override
  public Usuario mapRow(ResultSet rs, int arg1) throws SQLException {

    Usuario usuario = new Usuario();
    usuario.setApellidos(rs.getString("apellidos"));
    usuario.setCodigo(rs.getInt("codigo"));
    usuario.setEmail(rs.getString("email"));
    usuario.setfNacimiento(rs.getDate("fNacimiento"));
    usuario.setNombre(rs.getString("nombre"));
    usuario.setPass(rs.getString("pass"));
    return usuario;
  }

}
