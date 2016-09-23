package com.ipartek.formacion.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.dao.Mappers.EjemplarMapper;
import com.ipartek.formacion.dao.interfaces.EjemplarDAO;
import com.ipartek.formacion.dao.persistencia.Ejemplar;

@Repository
public class EjemplarDAOImp implements EjemplarDAO {

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Ejemplar create(Ejemplar ejemplar) {

		List<Ejemplar> lista = this.getAll();
		for (Ejemplar ej : lista) {
			if (ej.getEditorial().equalsIgnoreCase(ejemplar.getEditorial())
					&& ej.getnPaginas() == ejemplar.getnPaginas()) {
				String SQL = "UPDATE ejemplar SET editorial=?, nPaginas=?, idLibro = ?, disponible = ?, nEjemplares = ? WHERE codigo = ?";
				this.jdbcTemplate.update(SQL,
						new Object[] { ej.getEditorial(), ej.getnPaginas(), ej.getIdLibro(), ej.getDisponible(), ej.getnEjemplares() + ejemplar.getnEjemplares(), ej.getCodigo()});
			} else {
				String SQL = "INSERT INTO ejemplar (editorial, nPaginas, disponible) VALUE (?,?,?)";
				this.jdbcTemplate.update(
						SQL,
						new Object[] { ejemplar.getEditorial(),
								ejemplar.getnPaginas() });
			}
		}

		return ejemplar;
	}

	@Override
	public void delete(int id) {

		Ejemplar ej = this.getById(id);
		if(ej.getnEjemplares() > 1){
			String SQL = "UPDATE ejemplar SET editorial=?, nPaginas=?, idLibro = ?, disponible = ?, nEjemplares = ? WHERE codigo = ?";
			this.jdbcTemplate.update(SQL,
					new Object[] { ej.getEditorial(), ej.getnPaginas(), ej.getIdLibro(), ej.getDisponible(), ej.getnEjemplares() - 1, ej.getCodigo()});
		}else{
			String SQL = "DELETE FROM ejemplar WHERE codigo=?";
			this.jdbcTemplate.update(SQL, new Object[] { id });
		}
		
	}

	@Override
	public Ejemplar update(Ejemplar ejemplar) {
		String SQL = "UPDATE ejemplar SET editorial=?, nPaginas=?, idLibro = ?, disponible = ?, nEjemplares = ? WHERE codigo = ?";
		this.jdbcTemplate.update(SQL,
				new Object[] { ejemplar.getEditorial(), ejemplar.getnPaginas(), ejemplar.getIdLibro(), ejemplar.getDisponible(), ejemplar.getnEjemplares() - 1, ejemplar.getCodigo()});
		return ejemplar;
	}

	@Override
	public Ejemplar getById(int id) {
		String SQL = "SELECT * FROM ejemplar WHERE codigo=?";
		Ejemplar ejemplar = this.jdbcTemplate.queryForObject(SQL,
				new Object[] { id }, new EjemplarMapper());
		return ejemplar;
	}

	@Override
	public List<Ejemplar> getAll() {
		String SQL = "SELECT * FROM ejemplar";
		List<Ejemplar> ejemplares = this.jdbcTemplate.query(SQL,
				new EjemplarMapper());
		return ejemplares;
	}

}
