package com.ipartek.formacion.dao.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.ipartek.formacion.dao.persistencia.Ejemplar;
import com.ipartek.formacion.dao.persistencia.Libro;
import com.ipartek.formacion.dao.persistencia.Usuario;

public class LibroExtractor implements ResultSetExtractor<List<Libro>> {

	@Override
	public List<Libro> extractData(ResultSet rs) throws SQLException,
			DataAccessException {

		Map<Integer, Libro> libros = new HashMap<Integer, Libro>();
		Libro libro = null;

		while (rs.next()) {
			Integer id = rs.getInt("codLibro");
			libro = libros.get(id);

			if (libro == null) {
				libro = new Libro();
				libro.setCodLibro(rs.getInt("codLibro"));
				libro.setISBN(rs.getString("ISBN"));
				libro.setNombreApellidos(rs.getString("nombreApellidos"));
				libro.setTitulo(rs.getString("titulo"));

				libros.put(id, libro);
			}

			Usuario usuario = new Usuario();
			usuario.setApellidos(rs.getString("apellidos"));
			usuario.setNombre(rs.getString("nombre"));
			usuario.setCodUsuario(rs.getInt("codUsuario"));
			usuario.setEmail(rs.getString("email"));
			usuario.setfNacimiento(rs.getDate("fNacimiento"));
			usuario.setPass(rs.getString("pass"));

			Ejemplar ejemplar = new Ejemplar(usuario);
			ejemplar.setCodEjemplar(rs.getInt("codEjemplar"));
			ejemplar.setEditorial(rs.getString("editorial"));
			ejemplar.setnPaginas(rs.getInt("nPaginas"));

			libro.addEjemplares(ejemplar);

		}

		return new ArrayList<Libro>(libros.values());
	}

}
