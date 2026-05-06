package com.github.Radu_A.proyecto_05.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.Radu_A.proyecto_05.service.LotoServiceImpl;

@Controller
@RequestMapping("/loto")
public class LotoController {

	private LotoServiceImpl lotoService;

	public LotoController(LotoServiceImpl lotoService) {
		this.lotoService = lotoService;
	}

	@ModelAttribute("titulo")
	public String titulo() {
		return "Cuatro hojas";
	}

	@ModelAttribute("cabecera")
	public String cabecera() {
		return "Loto";
	}

	@GetMapping("/menu")
	public String menu(Model model) {
		return "loto/menu";
	}

	@GetMapping("/genera/{max}/{count}/{pais}")
	public String menu(Model model, @PathVariable int max, @PathVariable int count, @PathVariable String pais) {
		List<Integer> combinacion = lotoService.dameCombinacion(max, count);
		String paisMayuscula = pais.substring(0, 1).toUpperCase() + pais.substring(1);
		model.addAttribute("pais", paisMayuscula);
		model.addAttribute("combinacion", combinacion);
		return "loto/genera";
	}

}
