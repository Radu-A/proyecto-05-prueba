package com.github.Radu_A.proyecto_05.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.Radu_A.proyecto_05.model.Genero;
import com.github.Radu_A.proyecto_05.model.Libro;
import com.github.Radu_A.proyecto_05.repository.LibroRepository;

@Service
public class LibroServiceImpl implements ILibroService {
	
	private LibroRepository libroRepository;

	public LibroServiceImpl(LibroRepository libroRepository) {
		this.libroRepository = libroRepository;
	}

	@Override
	public List<Libro> findAll() {
		System.out.println(libroRepository.findAll());
		return libroRepository.findAll();
	}

	@Override
	public Libro findById(Long id) {
		return libroRepository.findById(id).orElse(null);
	}

	@Override
	public Libro save(Libro libro) {
		return libroRepository.save(libro);
	}

	@Override
	public void deleteById(Long id) {
		libroRepository.deleteById(id);
	}

	@Override
	public List<Libro> findByGenero(Genero genero) {
		return libroRepository.findByGenero(genero);
	}

}
