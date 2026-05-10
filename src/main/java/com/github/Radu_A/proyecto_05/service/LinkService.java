package com.github.Radu_A.proyecto_05.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LinkService implements ILinkService {

	@Override
	public List<String[]> dameLinks() {
		List<String[]> links = new ArrayList<>();
		String[] loto = {"/loto/menu", "loto"};
		String[] libros = {"/libros/menu", "libros"};
		String[] imagenes = {"/imagenes/menu", "imagenes"};
		links.add(loto);
		links.add(libros);
		links.add(imagenes);
		return links;
	}

}
