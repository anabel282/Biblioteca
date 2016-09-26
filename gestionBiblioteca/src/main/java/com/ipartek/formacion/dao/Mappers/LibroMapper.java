package com.ipartek.formacion.dao.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.dao.persistencia.Libro;

/*
 * No vamos a utilizar un mapper para libros, vamos a hacer un extractor poque necesitamos no solo que nos den los libros sino tb ejemplares y usuarios asociados.
 */
public class LibroMapper implements RowMapper<Libro> {

	@Override
	public Libro mapRow(ResultSet rs, int arg1) throws SQLException {

		Libro libro = new Libro();
		libro.setCodLibro(rs.getInt("codigo"));
		libro.setISBN(rs.getString("ISBN"));
		libro.setNombreApellidos(rs.getString("nombreApellidos"));
		libro.setTitulo(rs.getString("titulo"));

		return libro;
	}

}
