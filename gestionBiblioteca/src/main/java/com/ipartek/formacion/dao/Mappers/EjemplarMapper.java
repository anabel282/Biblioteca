package com.ipartek.formacion.dao.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.dao.persistencia.Ejemplar;
import com.ipartek.formacion.dao.persistencia.Usuario;

public class EjemplarMapper implements RowMapper<Ejemplar>{


	  @Override
	  public Ejemplar mapRow(ResultSet rs, int arg1) throws SQLException {

		Usuario usuario = new Usuario();
	    Ejemplar ejemplar = new Ejemplar(usuario);
	    ejemplar.setCodEjemplar(rs.getInt("codEjemplar"));
	    ejemplar.setEditorial(rs.getString("editorial"));
	    ejemplar.setnPaginas(rs.getInt("nPaginas"));
	    return ejemplar;
	  }

}
