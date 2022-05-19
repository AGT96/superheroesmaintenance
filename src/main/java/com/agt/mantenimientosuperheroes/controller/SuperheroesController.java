package com.agt.mantenimientosuperheroes.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agt.mantenimientosuperheroes.data.dto.ResponseMessage;

/**
 * The {@link SuperheroesController} exposes the superheroes api to use their endpoints.
 * 
 * @author AGT96
 */
@RestController
@RequestMapping("/api")
public class SuperheroesController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SuperheroesController.class);
	
	/**
	 * Retrieves all the superheroes from the database.
	 * 
	 * @return a {@link ResponseEntity} with the {@link HttpStatus} operation status
	 *         and a {@link ResponseMessage}.
	 */
	@GetMapping("/superheroes/all")
	public ResponseEntity<ResponseMessage> getAllSuperheroes(){
		LOGGER.info("Entering getAllSuperheroes method...");
		
		return null;
	}
	
	

}
