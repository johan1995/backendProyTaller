package com.proyecto.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.app.model.persona;

public interface PersonaRepository extends JpaRepository<persona, Long>{
	@SuppressWarnings("unchecked")
	persona save(persona pers);
}
