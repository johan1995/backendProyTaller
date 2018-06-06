package com.proyecto.app.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.app.dao.PersonaRepository;
import com.proyecto.app.model.persona;
import com.proyecto.app.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService{
	
		@Autowired
		protected PersonaRepository personaRepository;

		@Override
		public persona save(persona pers) {
			// TODO Auto-generated method stub
			return this.personaRepository.save(pers);
		}
	
}
