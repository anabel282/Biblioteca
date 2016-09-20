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
    String SQL = "INSERT INTO ejemplar (editorial, nPaginas) VALUE (?,?)";
    this.jdbcTemplate.update(SQL, new Object[] { ejemplar.getEditorial(), ejemplar.getnPaginas() });
    return ejemplar;
  }

  @Override
  public void delete(int id) {

    String SQL = "DELETE FROM ejemplar WHERE codigo=?";
    this.jdbcTemplate.update(SQL, new Object[] { id });
  }

  @Override
  public Ejemplar update(Ejemplar ejemplar) {
    String SQL = "UPDATE ejemplar SET editorial=?, nPaginas=? WHERE codigo=?";
    this.jdbcTemplate.update(SQL, new Object[] { ejemplar.getEditorial(), ejemplar.getnPaginas(),
        ejemplar.getCodigo() });
    return ejemplar;
  }

  @Override
  public Ejemplar getById(int id) {
    String SQL = "SELECT codigo, editorial, nPaginas FROM ejemplar WHERE codigo=?";
    Ejemplar ejemplar = this.jdbcTemplate.queryForObject(SQL, new Object[] { id },
        new EjemplarMapper());
    return ejemplar;
  }

  @Override
  public List<Ejemplar> getAll() {
    String SQL = "SELECT codigo, editorial, nPAginas FROM ejemplar";
    List<Ejemplar> ejemplares = this.jdbcTemplate.query(SQL, new EjemplarMapper());
    return ejemplares;
  }

}
