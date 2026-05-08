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

@Controller
@RequestMapping("/imagenes")
public class ImagenController {
	
	private ImagenServiceImpl imagenService;
	
	public ImagenController(ImagenServiceImpl imagenService) {
		this.imagenService = imagenService;
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
		return null;
	}
	
	@GetMapping("/respuesta/{solucionId}/{respuestaId}")
	public String respuesta(Model model, @PathVariable String solucionId, @PathVariable String respuestaId) {
		System.out.println(solucionId);
		System.out.println(respuestaId);
		model.addAttribute("solucionId", solucionId);
		model.addAttribute("imagenId", respuestaId);
		return "imagenes/respuesta";
	}
}
