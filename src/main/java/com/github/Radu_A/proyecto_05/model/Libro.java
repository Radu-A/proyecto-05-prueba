package com.github.Radu_A.proyecto_05.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "libros")
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String autor;
	private int ejemplares;
	@Enumerated(EnumType.STRING)
	private Genero genero;
	
	// Constructors
	public Libro() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Libro(String titulo, String autor, int ejemplares, Genero genero) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.ejemplares = ejemplares;
		this.genero = genero;
	}
	
	// Getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getEjemplares() {
		return ejemplares;
	}
	public void setEjemplares(int ejemplares) {
		this.ejemplares = ejemplares;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	public String toString() {
		return titulo;
	}
}
