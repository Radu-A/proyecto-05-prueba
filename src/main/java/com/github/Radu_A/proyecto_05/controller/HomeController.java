package com.github.Radu_A.proyecto_05.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.github.Radu_A.proyecto_05.service.LinkService;
import com.github.Radu_A.proyecto_05.service.ProverbioServiceImpl;

@Controller
public class HomeController {
	
	private ProverbioServiceImpl provervioService;
	
	private LinkService linkService;
	
	public HomeController(ProverbioServiceImpl provervioService, LinkService linkService) {
		this.provervioService = provervioService;
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
		return "Cuatro hojas";
	}
	
	@GetMapping({"", "/", "/home"})
	public String home(Model model) {
		model.addAttribute("proverbio", provervioService.dameProbervio());
		return "home";
	}
}
