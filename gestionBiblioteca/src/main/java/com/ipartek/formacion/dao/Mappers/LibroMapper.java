package com.ipartek.formacion.dao.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.dao.persistencia.Libro;

public class LibroMapper implements RowMapper<Libro> {

  @Override
  public Libro mapRow(ResultSet rs, int arg1) throws SQLException {

    Libro libro = new Libro();
    libro.setCodigo(rs.getInt("codigo"));
    libro.setISBN(rs.getString("ISBN"));
    libro.setNombreApellidos(rs.getString("nombreApellidos"));
    libro.setTitulo(rs.getString("titulo"));

    return libro;
  }

}
