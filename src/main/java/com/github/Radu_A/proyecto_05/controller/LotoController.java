package com.github.Radu_A.proyecto_05.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.Radu_A.proyecto_05.service.LotoService;

@Controller
@RequestMapping("/loto")
public class LotoController {

	private LotoService lotoService;

	public LotoController(LotoService lotoService) {
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
	public String menu(Model model, @PathVariable int max, @PathVariable int count, @PathVariable int pais) {
		List<Integer> combinacion = lotoService.dameCombinacion(max, count);
		model.addAttribute("pais", pais);
		
		return "loto/menu";
	}

}
