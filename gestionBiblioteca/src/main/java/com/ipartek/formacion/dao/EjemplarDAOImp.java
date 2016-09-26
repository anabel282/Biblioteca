package com.ipartek.formacion.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.dao.Mappers.EjemplarMapper;
import com.ipartek.formacion.dao.Mappers.LibroExtractor;
import com.ipartek.formacion.dao.interfaces.EjemplarDAO;
import com.ipartek.formacion.dao.persistencia.Ejemplar;
import com.ipartek.formacion.dao.persistencia.Libro;

/*
 * Esta clase va a gestionar tanto la parte de ejemplar como la parte de libro, suponemos que todas las acciones de ejemplar estan relacionadas con las de libro, es decir para crear un libro tenemos que crear tb un ejemplar
 */

@Repository
public class EjemplarDAOImp implements EjemplarDAO {

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall sJdbcCall;

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {

		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.sJdbcCall = new SimpleJdbcCall(dataSource);
	}

	@Override
	public Ejemplar create(Ejemplar ejemplar) {

		String SQL = "CREAR EJEMPLAR";
		this.sJdbcCall.withProcedureName(SQL);
		SqlParameterSource sps = new MapSqlParameterSource()
				.addValue("editorial", ejemplar.getEditorial())
				.addValue("ISBN", ejemplar.getISBN())
				.addValue("titulo", ejemplar.getTitulo())
				.addValue("nPaginas", ejemplar.getnPaginas())
				.addValue("nombreApellidos", ejemplar.getNombreApellidos());
		;
		this.sJdbcCall.execute(sps);

		return ejemplar;
	}

	@Override
	public void delete(int id) {

		String SQL = "BORRAR EJEMPLAR";
		
		this.sJdbcCall.withProcedureName(SQL);
		
		SqlParameterSource sps = new MapSqlParameterSource().addValue("codEjemplar", id);
		
		this.sJdbcCall.equals(sps);
	}

	@Override
	public Ejemplar update(Ejemplar ejemplar) {

		String SQL = "UPDATE EJEMPLAR";
		this.sJdbcCall.withProcedureName(SQL);
		SqlParameterSource sps = new MapSqlParameterSource()
				.addValue("editorial", ejemplar.getEditorial())
				.addValue("codLibro", ejemplar.getCodLibro())
				.addValue("codEjemplar", ejemplar.getEjemplares())
				.addValue("ISBN", ejemplar.getISBN())
				.addValue("titulo", ejemplar.getTitulo())
				.addValue("nPaginas", ejemplar.getnPaginas())
				.addValue("nombreApellidos", ejemplar.getNombreApellidos());
		;
		this.sJdbcCall.equals(sps);
		return ejemplar;
	}

	@Override
	public Ejemplar findLibro(int id) {

		String SQL = "SELECT codEjemplar, editorial, nPaginas, idLibro, disponibles FROM ejemplar WHERE codEjemplar=?";
		Ejemplar ejemplar = this.jdbcTemplate.queryForObject(SQL,
				new Object[] { id }, new EjemplarMapper());
		return ejemplar;
	}

	/**
	 * Metodo que se va a encargar de devolvernos una lista con todos los libros
	 * que tenemos, junto con sus ejemplares y si estos ejemplares tienen
	 * usuario o no.
	 */
	@Override
	public List<Libro> getAll() {

		String SQL = "OBTENER_LIBROS";

		List<Libro> libros = this.jdbcTemplate.query(SQL, new LibroExtractor());
		return libros;
	}

}
