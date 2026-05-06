package com.github.Radu_A.proyecto_05.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class ProverbioServiceImpl implements IProverbioService {

	private String[] proverbios = { "Un viaje de diez mil kilómetros empieza con un solo paso.",
			"Ten paciencia en un momento de ira y te ahorrarás cien días de arrepentimiento.",
			"Aprender es un tesoro que seguirá a su dueño a todas partes.",
			"El mejor momento para plantar un árbol fue hace veinte años. El segundo mejor momento es ahora.",
			"No temas ir despacio, teme solo detenerte.", "Si te caes siete veces, levántate ocho.",
			"El viento no ayuda a quien no sabe a qué puerto se dirige.",
			"Las torres más altas se elevan desde el suelo.",
			"El maestro abre la puerta, pero tú debes entrar por ti mismo.",
			"Si quieres saber cómo es el camino, pregunta a los que vienen de vuelta.", };

	@Override
	public String dameProbervio() {
		Random r = new Random();
		int i = r.nextInt(10);
		return proverbios[i];
	}

}
