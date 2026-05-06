package com.github.Radu_A.proyecto_05.service;

import java.util.List;

import com.github.Radu_A.proyecto_05.model.Genero;
import com.github.Radu_A.proyecto_05.model.Libro;

public interface ILibroService {
	
	List<Libro> findAll();
	Libro findById(Long id);
	Libro save(Libro libro);
	void deleteById(Long id);
	List<Libro> findByGenero(Genero genero);
}
