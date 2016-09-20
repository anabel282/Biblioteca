package com.ipartek.formacion.dao.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.dao.persistencia.Ejemplar;

public class EjemplarMapper implements RowMapper<Ejemplar> {

  @Override
  public Ejemplar mapRow(ResultSet rs, int arg1) throws SQLException {

    Ejemplar ejemplar = new Ejemplar();
    ejemplar.setCodigo(rs.getInt("codigo"));
    ejemplar.setEditorial(rs.getString("editorial"));
    ejemplar.setnPaginas(rs.getInt("nPaginas"));
    return ejemplar;
  }

}
