package com.ipartek.formacion.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ipartek.formacion.dao.persistencia.Usuario;

public class UsuarioValidator implements Validator {

	/*
	 * Las validaciones del usuario, las voy a hacer con el validador de Spring
	 * (@Validated) y las de libro y ejemplar con el de java (@Valid) para tener
	 * ambas opciones
	 */
	@Override
	public boolean supports(Class<?> arg) {
		return Usuario.class.equals(arg);
	}

	@Override
	public void validate(Object object, Errors errors) {

		Usuario usuario = (Usuario) object;
		if (usuario.getNombre().length() < 2) {
			errors.rejectValue("nombre", "ValorInvalido",
					new Object[] { "'nombre'" },
					"El nombre tiene que tener mas de un caracter");
		}
		if (usuario.getApellidos().length() < 6) {
			errors.rejectValue("apellidos", "ValorInvalido",
					new Object[] { "'apellidos'" },
					"Los apellidos tiene que tener mas de 5 caracteres");
		}
		if (usuario.getPass().matches(
						"(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{6,}$")) {
			System.out.println("Entra en la contraseña");
			errors.rejectValue("pass", "ValorInvalido",
					new Object[] { "'pass'" },
					"La contraseña tiene que tener mas de 5 caracteres");
			/*
			 * La \ escapa, por lo tanto tienes que poner otra \ para que haga
			 * efecto, vemos abajo la explicacion String ruta = "C:\""; // -->
			 * C:" ruta = "c:\\"; // ---> c:\
			 */

		}
	}
}
