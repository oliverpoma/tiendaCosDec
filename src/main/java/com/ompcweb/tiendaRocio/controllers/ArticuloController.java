package com.ompcweb.tiendaRocio.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.ompcweb.tiendaRocio.models.entities.Articulo;
import com.ompcweb.tiendaRocio.models.services.ArticuloService;

@Controller
@SessionAttributes("articulo")
public class ArticuloController {
	
	@Autowired
	private ArticuloService articuloService;
	
	@GetMapping("/")
	public String mostrar (Model model){
		model.addAttribute("articulos", articuloService.findAll());

		return "index";
	}
	
	@GetMapping("/listar")
	public String listar (Model model){
		model.addAttribute("titulo", "Lista de Articulos");
		model.addAttribute("articulos", articuloService.findAll());

		return "listar";
	}
	
	@GetMapping("/publicar")
	public String crear (Model model) {
		Articulo articulo = new Articulo();
		model.addAttribute("titulo", "Formulario de subida");
		model.addAttribute("articulo", articulo);
		return "publicar";
	}
	
	@PostMapping("/publicar")
	public String publicar (@Valid Articulo articulo, BindingResult result, SessionStatus status) {
		if(result.hasErrors()) {
			return "publicar";
		}
		articuloService.save(articulo);
		status.setComplete();
		return "redirect:/listar";
	}

	@GetMapping("/editar/{id}")
	public String editar (@PathVariable("id") Long id, Model model) {
		model.addAttribute("articulo", articuloService.findById(id));
		return "publicar";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar (@PathVariable("id") Long id) {
		articuloService.deleteById(id);
		return "redirect:/listar";
	}
}
