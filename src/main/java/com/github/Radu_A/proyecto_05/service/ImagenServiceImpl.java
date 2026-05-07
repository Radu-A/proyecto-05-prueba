package com.github.Radu_A.proyecto_05.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.Radu_A.proyecto_05.model.Imagen;
import com.github.Radu_A.proyecto_05.repository.ImagenRepository;

@Service
public class ImagenServiceImpl implements IImagenService {

	private ImagenRepository imagenRepository;
	
	private List<Imagen> imagenes;

	public ImagenServiceImpl(ImagenRepository imagenRepository) {
		this.imagenRepository = imagenRepository;
	}


	@Override
	public Imagen findById(Long id) {
		return imagenRepository.findById(id).orElse(null);
	}

	@Override
	public List<Imagen> findAll() {
		return imagenRepository.findAll();
	}
	
	public List<Imagen> damePartida() {
		List<Imagen> imagenes = findAll();
		List<Imagen> partida = new ArrayList<>();
		Collections.shuffle(imagenes);
		for (int i = 0; i < 4; i++) {
			partida.add(imagenes.get(i));
		}
		System.out.println(partida);
		return partida;
	}

}
