package com.ipartek.formacion.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.formacion.dao.persistencia.Libro;
import com.ipartek.formacion.service.interfaces.LibroService;

@RequestMapping("/libroRest")
public class LibroRestController {
	
	@Autowired
	private LibroService libroService;
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") int id){
		ResponseEntity<Void> respuesta = null;
		if(this.libroService.getById(id) != null){
			respuesta = new ResponseEntity<Void>(HttpStatus.OK);
			this.libroService.delete(id);
		}else{
			respuesta = new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		return respuesta;
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Libro> getById(@PathVariable("id") int id){
		ResponseEntity<Libro> respuesta = null;
		Libro libro = this.libroService.getById(id);
		if(libro != null || libro.getCodigo() > 0){
			respuesta = new ResponseEntity<Libro>(libro, HttpStatus.OK);
			this.libroService.delete(id);
		}else{
			respuesta = new ResponseEntity<Libro>(HttpStatus.NOT_FOUND);
		}
		return respuesta;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Libro>> getAll(){
		ResponseEntity<List<Libro>> respuesta;
		List<Libro> libros = libroService.getAll();
		if(libros!=null && libros.size()>0){
			respuesta = new ResponseEntity<List<Libro>>(libros, HttpStatus.OK);
		}else{
			respuesta = new ResponseEntity<List<Libro>>(HttpStatus.NOT_FOUND);
		}
		return respuesta;
	}
	
	
}
