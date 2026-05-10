package com.github.Radu_A.proyecto_05.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.Radu_A.proyecto_05.model.Genero;
import com.github.Radu_A.proyecto_05.model.Libro;
import com.github.Radu_A.proyecto_05.service.LibroServiceImpl;
import com.github.Radu_A.proyecto_05.service.LinkService;

@Controller
@RequestMapping("/libros")
public class LibroController {
	
	private LibroServiceImpl libroService;
	
	private LinkService linkService;

	public LibroController(LibroServiceImpl libroService, LinkService linkService) {
		this.libroService = libroService;
		this.linkService = linkService;
	}
	
	@ModelAttribute("links")
	public List<String[]> links() {
		return linkService.dameLinks();
	}

	@ModelAttribute("titulo")
	public String titulo() {
		return "Cuatro hojas";
	}

	@ModelAttribute("cabecera")
	public String cabecera() {
		return "Libros";
	}	
	
	@GetMapping("/menu")
	public String listado(Model model) {
		model.addAttribute("cabecera", "Listado de libros");
		model.addAttribute("libros", libroService.findAll());
		model.addAttribute("accion1", "Detalles");
		model.addAttribute("accion2", "Borrar");
		model.addAttribute("accion3", "Actualizar");
		model.addAttribute("generos", Genero.values());
		return "libros/menu";
	}
	
	@GetMapping("/detalles/{id}")
	public String findById(Model model, @PathVariable Long id) {
		Libro libro = libroService.findById(id);
		model.addAttribute("cabecera", "Información del libro: " + libro.getTitulo());
		model.addAttribute("libro", libro);
		return "libros/detalles";
	}
	
	@GetMapping("/borrar/{id}")
	public String deleteById(Model model, @PathVariable Long id) {
		libroService.deleteById(id);
		return "redirect:/libros/menu";
	}
	
	@GetMapping("/form/{id}")
	public String actualizar(Model model, @PathVariable Long id) {
		Libro libro = libroService.findById(id);
		model.addAttribute("cabecera", "Editar");
		model.addAttribute("libro", libro);
		model.addAttribute("boton", "Actualizar");
		return "libros/form";
	}
	
	@PostMapping("/guardar")
	public String guardar(Libro libro) {
		libroService.save(libro);
		return "redirect:/libros/menu";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		model.addAttribute("cabecera", "Nuevo libro");
		model.addAttribute("libro", new Libro());
		model.addAttribute("boton", "Crear");
		return "libros/form";
	}
	
	@GetMapping("/filtro/{genero}")
	public String filtrar(Model model, @PathVariable Genero genero) {
		model.addAttribute("cabecera", "Listado de articulos");
		model.addAttribute("libros", libroService.findByGenero(genero));
		model.addAttribute("accion1", "Detalles");
		model.addAttribute("accion2", "Borrar");
		model.addAttribute("accion3", "Actualizar");
		model.addAttribute("generos", Genero.values());
		return "libros/menu";
	}
}
