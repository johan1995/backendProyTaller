package com.proyecto.app.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.app.model.persona;
import com.proyecto.app.service.PersonaService;
import com.proyecto.app.util.RestResponse;

@RestController
public class PersonaController {
	
	@Autowired
	protected PersonaService personaService;
	
	protected ObjectMapper mapper;
	
	@RequestMapping(value= "/saveOrUpdate", method = RequestMethod.POST)
	public RestResponse saveOrUpdate(@RequestBody String personaJson) throws JsonParseException, JsonMappingException, IOException {
		this.mapper= new ObjectMapper();
		
		persona pers=this.mapper.readValue(personaJson, persona.class);
		
		if (this.validate(pers)==false) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),"error al ingrear campos obligatorios");
			
		}
		
		this.personaService.save(pers);
		
		return new RestResponse(HttpStatus.OK.value(),"Operacion Exitosa");
	}
	
	private boolean validate(persona pers) {
		boolean isValid=true;
		
		if (pers.getNombre()==null) {
			isValid=false;
		}
		if (pers.getApellido()==null) {
			isValid=false;
		}
		
		if (pers.getNum_documento()==null) {
			isValid=false;
		}
		
		if (pers.getTelefono()==null) {
			isValid=false;
		}
		
		return isValid;
	}
	
}
