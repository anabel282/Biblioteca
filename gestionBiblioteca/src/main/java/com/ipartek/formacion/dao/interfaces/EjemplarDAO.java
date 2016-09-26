package com.ipartek.formacion.dao.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.persistencia.Ejemplar;
import com.ipartek.formacion.dao.persistencia.Libro;

public interface EjemplarDAO extends SetterDS {

  public Ejemplar create(Ejemplar ejemplar);

  public void delete(int id);

  public Ejemplar update(Ejemplar ejemplar);

  public Libro findLibro(int id);

  public List<Libro> getAll();
}
