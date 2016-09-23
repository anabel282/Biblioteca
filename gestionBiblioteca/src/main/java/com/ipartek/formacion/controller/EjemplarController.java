package com.ipartek.formacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.dao.persistencia.Ejemplar;
import com.ipartek.formacion.service.interfaces.EjemplarService;

@Controller
@RequestMapping("/ejemplar")
public class EjemplarController {

  // private final static Logger log = new LoggerFactory.getLogger(EjemplarController.class);
  @Autowired
  private EjemplarService eService;
  private ModelAndView mav;

  @Qualifier("EjemplarValidator")
  private Validator validator;

  @InitBinder
  private void initBinder(WebDataBinder binder) {
    binder.setValidator(validator);
  }

  /*
   * El requestMethod.DELETE solo se va a dar al borrar. LOS BOTONES SIEMPRE VAN POR GET, si
   * queremos que sea por POST tiene que ser un formulario
   */
  @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
  public String delete(@PathVariable("id") int id) {
    this.eService.delete(id);
    return "redirect:/ejemplar/";
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ModelAndView getById(@PathVariable("id") int id) {
    this.mav = new ModelAndView("ejemplar/ejemplar");
    Ejemplar ejemplar = this.eService.getById(id);
    this.mav.addObject("ejemplar", ejemplar);
    return this.mav;
  }

  @RequestMapping(method = RequestMethod.GET)
  public ModelAndView getAll() {
    this.mav = new ModelAndView("ejemplar/listado");
    List<Ejemplar> ejemplars = this.eService.getAll();
    this.mav.addObject("ejemplares", ejemplars);
    return this.mav;
  }

  @RequestMapping(value = "updateCreate", method = RequestMethod.GET)
  public String updateCreate(Model model) {

    model.addAttribute(new Ejemplar());
    return "ejemplar/ejemplar";
  }

  @RequestMapping(value = "saveEjemplar", method = RequestMethod.POST)
  public String saveEjemplar(@ModelAttribute("ejemplar") @Validated Ejemplar ejemplar,
      BindingResult bindingResult) {

    String resultado = null;

    if (bindingResult.hasErrors()) {
      resultado = "ejemplar/ejemplar";
      // log.info("Error al introducir el ejemplar");
    } else {
      if (ejemplar.getCodigo() > 0) {
        this.eService.update(ejemplar);
        resultado = "redirect:/ejemplar/";
      } else {
        this.eService.create(ejemplar);
        resultado = "redirect:/ejemplar/";
      }
    }

    return resultado;
  }
}
