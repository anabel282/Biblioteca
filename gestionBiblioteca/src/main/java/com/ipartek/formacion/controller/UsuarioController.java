package com.ipartek.formacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.dao.persistencia.Usuario;
import com.ipartek.formacion.service.interfaces.UsuarioService;

/*
 * TODOS LOS BOTONES O ENLACES SON GET
 */
@Controller
@RequestMapping("/usuario")
public class UsuarioController {

  @Autowired
  private UsuarioService uService;
  private ModelAndView mav;

  @RequestMapping(value = "delete/{id}", method = { RequestMethod.GET })
  public String delete(@PathVariable("id") int id) {
    this.uService.delete(id);
    return "redirect:/usuario/";
  }

  @RequestMapping(value = "/{id}", method = { RequestMethod.GET })
  public ModelAndView getById(@PathVariable("id") int id) {

    this.mav = new ModelAndView("usuario/usuario");
    Usuario usuario = this.uService.getById(id);
    this.mav.addObject("usuario", usuario);
    return this.mav;
  }

  @RequestMapping(method = RequestMethod.GET)
  public ModelAndView getAll() {
    this.mav = new ModelAndView("usuario/listado");
    List<Usuario> usuarios = this.uService.getAll();
    this.mav.addObject("usuarios", usuarios);
    return this.mav;
  }

  @RequestMapping(value = "/createUpdate", method = RequestMethod.GET)
  public String createUpdate(Model model) {
    model.addAttribute(new Usuario());
    return "usuario/usuario";
  }

  /*
   * Ponemos el modelAttribute para indicarle que del formulario vamos a recibir un OBJETO, al
   * contrario que con el PathVariable que lo que vamos a exploner es que mandamos un dato primario
   */
  @RequestMapping(value = "/saveUsuario", method = RequestMethod.POST)
  public String saveUsuario(@ModelAttribute("usuario") @Validated Usuario usuario,
      BindingResult bindingResult) {

    String resultado = null;

    if (bindingResult.hasErrors()) {
      resultado = "usuario/usuario";
    } else {
      if (usuario.getCodigo() > 0) {
        resultado = "redirect:/usuario/";
        this.uService.update(usuario);
      } else {
        resultado = "redirect:/usuario/";
        this.uService.create(usuario);
      }
    }

    return resultado;

  }
}
