package com.github.Radu_A.proyecto_05.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.Radu_A.proyecto_05.model.Imagen;
import com.github.Radu_A.proyecto_05.service.ImagenServiceImpl;
import com.github.Radu_A.proyecto_05.service.LinkService;

@Controller
@RequestMapping("/imagenes")
public class ImagenController {
	
	private ImagenServiceImpl imagenService;
	
	private LinkService linkService;
	
	public ImagenController(ImagenServiceImpl imagenService, LinkService linkService) {
		this.imagenService = imagenService;
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
		return "Imagenes";
	}	

	@GetMapping("/menu")
	public String menu(Model model) {
		List<Imagen> partida = imagenService.damePartida();
		Imagen solucion = partida.get(0);
		model.addAttribute("foto", solucion.getRutaImagen());
		model.addAttribute("solucion", solucion);
		Collections.shuffle(partida);
		model.addAttribute("partida", partida);
		return "imagenes/menu";
	}
	
	@GetMapping("/respuesta/{solucionId}/{respuestaId}")
	public String respuesta(Model model, @PathVariable Long solucionId, @PathVariable Long respuestaId) {
		System.out.println(solucionId);
		System.out.println(respuestaId);
		Imagen solucion = imagenService.findById(solucionId);
		model.addAttribute("solucion", solucion);
		model.addAttribute("imagenId", respuestaId);
		return "imagenes/respuesta";
	}
}
