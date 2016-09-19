package com.ipartek.formacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.dao.persistencia.Ejemplar;
import com.ipartek.formacion.service.interfaces.EjemplarService;

@Controller("/ejemplar")
public class EjemplarController {

	@Autowired
	private EjemplarService eService;
	private ModelAndView mav;
	
	@RequestMapping(value="/{id}", method = {RequestMethod.DELETE, RequestMethod.POST})
	public String delete(@PathVariable("id") int id){
		this.eService.delete(id);
		return "redirect:/ejemplar";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getById(@PathVariable("id") int id){
		this.mav = new ModelAndView("ejemplar/ejemplar");
		Ejemplar ejemplar = this.eService.getById(id);
		this.mav.addObject("ejemplar", ejemplar);
		return this.mav;
	}
	
	@RequestMapping(value="/listado", method=RequestMethod.GET)
	public ModelAndView getAll(){
		this.mav = new ModelAndView("ejemplar/listado");
		List<Ejemplar> ejemplars = this.eService.getAll();
		this.mav.addObject("ejemplares", ejemplars);
		return this.mav;
	}
	
	@RequestMapping(value="updateCreate", method= RequestMethod.POST)
	public String updateCreate(Model model){
		
		model.addAttribute(new Ejemplar());
		return "redirect:/saveEjemplar";
	}
	
	@RequestMapping(value="saveEjemplar", method= RequestMethod.POST)
	public String saveEjemplar(Ejemplar ejemplar){
		if(ejemplar.getCodigo() > 0){
			this.eService.update(ejemplar);
		}else{
			this.eService.create(ejemplar);
		}
		return "redirect:/ejemplar";
	}
}
