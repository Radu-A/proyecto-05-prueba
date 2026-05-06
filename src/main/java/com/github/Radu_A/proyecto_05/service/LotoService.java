package com.github.Radu_A.proyecto_05.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LotoService implements ILotoService {
	
	@Override
	public List<Integer> dameCombinacion(int max, int count) {
		List<Integer> bombo = new ArrayList<>();
		List<Integer> combinacion = new ArrayList<>();
		for (int i = 1; i <= max; i++) {
			bombo.add(i);
		}
		Collections.shuffle(bombo);
		for (int i = 0; i < count; i++) {
			combinacion.add(i);			
		}
		return combinacion;
	}

}
