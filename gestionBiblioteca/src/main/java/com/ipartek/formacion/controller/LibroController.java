package com.ipartek.formacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.dao.persistencia.Libro;
import com.ipartek.formacion.service.interfaces.LibroService;

@Controller("/libro")
public class LibroController {

	@Autowired
	private LibroService libroService;
	private ModelAndView mav;
	
	@RequestMapping(value="/{id}", method={RequestMethod.DELETE, RequestMethod.POST})
	public String delete(@PathVariable("id") int id){
		this.libroService.delete(id);
		return "redirect:/libro";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ModelAndView getById(@PathVariable("id")int id){
		this.mav = new ModelAndView("libro/libro");
		Libro libro = this.libroService.getById(id);
		this.mav.addObject("libro", libro);
		return this.mav;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getAll(){
		this.mav = new ModelAndView("libro/listado");
		List<Libro> libros = this.libroService.getAll();
		this.mav.addObject("listado-libros", libros);
		return this.mav;
	}
	
	@RequestMapping(value="/createUpdate", method=RequestMethod.POST)
	public String createUpdate(Model model){
		model.addAttribute(new Libro());
		return "redirect:/saveLibro";
	}
	
	@RequestMapping(value="/saveLibro", method=RequestMethod.POST)
	public String saveLibro(Libro libro){
		
		if(libro.getCodigo() > 0){
			this.libroService.update(libro);
		}else{
			this.libroService.create(libro);
		}
		return "redirect:/libro";
	}
}
