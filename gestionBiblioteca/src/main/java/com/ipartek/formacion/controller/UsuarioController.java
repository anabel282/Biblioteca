package com.ipartek.formacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.dao.persistencia.Usuario;
import com.ipartek.formacion.service.interfaces.UsuarioService;

@Controller("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService uService;
	private ModelAndView mav;
	
	@RequestMapping(value="/{id}", method={RequestMethod.DELETE, RequestMethod.POST})
	public String delete(@PathVariable("id") int id){
		this.uService.delete(id);
		return "redirect:/usuario";
	}
	
	@RequestMapping(value="/{id}", method={RequestMethod.GET})
	public ModelAndView getById(@PathVariable("id") int id){
		
		this.mav = new ModelAndView("usuario/usuario");
		Usuario usuario = this.uService.getById(id);
		this.mav.addObject("usuario", usuario);
		return this.mav;
	}
	
	@RequestMapping(value="listado",method=RequestMethod.GET)
	public ModelAndView getAll(){
		this.mav = new ModelAndView("usuario/listado");
		List<Usuario> usuarios = this.uService.getAll();
		this.mav.addObject("lista-usuarios", usuarios);
		return this.mav;
	}
	
	@RequestMapping(value="/")
	public String createUpdate(Model model){
		model.addAttribute(new Usuario());
		return "redirect:/saveUsuario";
	}
	
	@RequestMapping(value="/saveUsuario")
	public String saveUsuario(Usuario usuario){
		if(usuario.getCodigo()>0){
			this.uService.update(usuario);
		}else{
			this.uService.create(usuario);
		}
		return "redirect:/usuario";
		
	}
}
