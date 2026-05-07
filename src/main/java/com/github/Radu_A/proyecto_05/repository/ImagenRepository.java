package com.github.Radu_A.proyecto_05.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.Radu_A.proyecto_05.model.Imagen;

@Repository
public interface ImagenRepository extends JpaRepository<Imagen, Long>  {
	
}
