package com.ipartek.formacion.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ipartek.formacion.dao.persistencia.Ejemplar;

public class EjemplarValidator implements Validator {

  @Override
  public boolean supports(Class<?> clazz) {
    return Ejemplar.class.equals(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {

    Ejemplar ejemplar = (Ejemplar) target;
    if (ejemplar.getnPaginas() < 5) {
      errors.rejectValue("nPaginas", "ValorInvalido", new Object[] { "'nPaginas'" },
          "El numero de paginas tiene que ser mayor de 5 paginas");
    }
  }

}
