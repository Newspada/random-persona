package com.facchinil.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facchinil.dto.PersonaDTO;
import com.facchinil.manager.PersonaManager;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class PersonaController {
	
	@Autowired
	private PersonaManager personaManager;
	
	@GetMapping("")
	public PersonaDTO getRandomPersona() {
		return personaManager.getRandom();
	}
}