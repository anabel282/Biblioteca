package com.ipartek.formacion.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.dao.persistencia.Libro;
import com.ipartek.formacion.service.interfaces.LibroService;



@Controller
@RequestMapping("/libro")
public class LibroController {

  @Autowired
  private LibroService libroService;
  private ModelAndView mav;
  private Logger log;

  @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
  public String delete(@PathVariable("id") int id) {
    this.libroService.delete(id);
    return "redirect:/libro/";
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ModelAndView getById(@PathVariable("id") int id) {
    this.mav = new ModelAndView("libro/libro");
    Libro libro = this.libroService.getById(id);
    this.mav.addObject("libro", libro);
    return this.mav;
  }

  @RequestMapping(method = RequestMethod.GET)
  public ModelAndView getAll() {
    this.mav = new ModelAndView("libro/listado");
    List<Libro> libros = this.libroService.getAll();
    this.mav.addObject("libros", libros);
    return this.mav;
  }

  @RequestMapping(value = "/createUpdate", method = RequestMethod.GET)
  public String createUpdate(Model model) {
    model.addAttribute(new Libro());
    return "libro/libro";
  }

  @RequestMapping(value = "/saveLibro", method = RequestMethod.POST)
  public String saveLibro(@ModelAttribute("libro") @Valid Libro libro, BindingResult bindingResult) {

    String resultado = null;

    if (bindingResult.hasErrors()) {
      resultado = "libro/libro";
      // log.info("El libro esta dando un error al crearse");
    } else {
      if (libro.getCodLibro()> 0) {
        this.libroService.update(libro);
        resultado = "redirect:/libro/";
      } else {
        this.libroService.create(libro);
        resultado = "redirect:/libro/";
      }
    }

    return resultado;
  }
}
