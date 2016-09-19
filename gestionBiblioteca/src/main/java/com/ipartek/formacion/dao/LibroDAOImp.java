package com.ipartek.formacion.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.dao.interfaces.LibroDAO;
import com.ipartek.formacion.dao.persistencia.Libro;

@Repository
public class LibroDAOImp implements LibroDAO {

  @Autowired
  private DataSource dataSource;
  private JdbcTemplate jdbcTemplate;

  @Override
  public void SetterDataSoruce(DataSource dataSource) {

    this.dataSource = dataSource;
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }

  @Override
  public Libro create(Libro libro) {
    String SQL = "INSERT INTO libro (titulo, nombreApellidos, ISBN) VALUE (?,?,?)";
    this.jdbcTemplate.update(SQL, new Object[] { libro.getTitulo(), libro.getNombreApellidos(),
        libro.getISBN() });
    return libro;
  }

  @Override
  public void delete(int id) {

    String SQL = "DELETE FROM libro WHERE codigo=?";
    this.jdbcTemplate.update(SQL, new Object[] { id });
  }

  @Override
  public Libro update(Libro libro) {

    String SQL = "UPDATE libro SET titulo=?, nombreApellidos=?, ISBN=? WHERE codigo=?";
    this.jdbcTemplate.update(SQL, new Object[] { libro.getTitulo(), libro.getNombreApellidos(),
        libro.getISBN(), libro.getCodigo() });
    return libro;
  }

  @Override
  public Libro getById(int id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Libro> getAll() {
    // TODO Auto-generated method stub
    return null;
  }

}
