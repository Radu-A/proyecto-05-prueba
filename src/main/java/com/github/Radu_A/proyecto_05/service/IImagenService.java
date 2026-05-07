package com.github.Radu_A.proyecto_05.service;

import java.util.List;

import com.github.Radu_A.proyecto_05.model.Imagen;

public interface IImagenService {
	
	Imagen findById(Long id);
	List<Imagen> findAll();
}
