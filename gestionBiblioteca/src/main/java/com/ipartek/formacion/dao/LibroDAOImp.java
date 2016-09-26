package com.ipartek.formacion.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.dao.Mappers.LibroMapper;
import com.ipartek.formacion.dao.interfaces.LibroDAO;
import com.ipartek.formacion.dao.persistencia.Libro;

/*
 * Esta clase no se utiliza para nada, ya que libro siempre depende de ejemplar, seran los ejemplares los que mostremos, no los libros
 */

@Repository
public class LibroDAOImp implements LibroDAO {

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
  public Libro create(Libro libro) {
    String SQL = "INSERT INTO libro (titulo, nombreApellidos, ISBN) VALUE (?,?,?)";
    this.jdbcTemplate.update(SQL, new Object[] { libro.getTitulo(), libro.getNombreApellidos(),
        libro.getISBN() });
    return libro;
  }

  @Override
  public void delete(int id) {

    String SQL = "DELETE FROM libro WHERE codLibro=?";
    this.jdbcTemplate.update(SQL, new Object[] { id });
  }

  @Override
  public Libro update(Libro libro) {

    String SQL = "UPDATE libro SET titulo=?, nombreApellidos=?, ISBN=? WHERE codLibro=?";
    this.jdbcTemplate.update(SQL, new Object[] { libro.getTitulo(), libro.getNombreApellidos(),
        libro.getISBN(), libro.getCodLibro()});
    return libro;
  }

  @Override
  public Libro getById(int id) {

    String SQL = "SELECT codLibro, titulo, nombreApellidos, ISBN FROM libro WHERE codLibro=?";
    Libro libro = this.jdbcTemplate.queryForObject(SQL, new Object[] { id }, new LibroMapper());
    return libro;
  }

  @Override
  public List<Libro> getAll() {

    String SQL = "SELECT codLibro, titulo, nombreApellidos, ISBN FROM libro";
    List<Libro> libros = this.jdbcTemplate.query(SQL, new LibroMapper());
    return libros;
  }

}
