package com.agt.mantenimientosuperheroes.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;

import com.agt.mantenimientosuperheroes.config.ControllerConfigTest;

import com.agt.mantenimientosuperheroes.service.data.dto.SuperHeroDto;
import com.agt.mantenimientosuperheroes.service.data.entities.SuperHero;
import com.google.gson.Gson;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

class SuperHeroControllerTest extends ControllerConfigTest {
	
	private PodamFactory factory  = new PodamFactoryImpl();

	@Test
	void testGetAllSuperHeroes() {
		
		try {
			
			List<SuperHeroDto> superHeroDtoLst = new ArrayList<>();
			
			SuperHeroDto dto = factory.manufacturePojo(SuperHeroDto.class);
			
			superHeroDtoLst.add(dto);
			
			Mockito.when(service.getAllContent()).thenReturn(superHeroDtoLst);
			
			mvc.perform(get("/api/superhero/all")).andExpect(status().isOk());
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Test
	void testGetById() {
		
		try {
			
			SuperHeroDto dto = new SuperHeroDto(); // Create the given objects for the mock actions.
			dto.setId(1);

			Mockito.when(service.getById(Mockito.anyInt())).thenReturn(dto); // Define the service mock behavior.

			mvc.perform(get("/api/superhero/{id}", 1)).andExpect(status().isOk()); // test the controller endpoint.
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Test
	void testGetByName() {
		
		SuperHeroDto dto = new SuperHeroDto();
		dto.setName("super");

		List<SuperHeroDto> dtoLst = new ArrayList<>();
		dtoLst.add(dto);

		Mockito.when(service.getByNameContaining(Mockito.anyString())).thenReturn(dtoLst);

		try {
			mvc.perform(get("/api/superhero/byName/{name}", "super")).andExpect(status().isOk());
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Test
	void testCreateSuperHero() {
		
		SuperHeroDto dto = new SuperHeroDto();
		dto.setId(1);
		dto.setName("super");

		SuperHero entityToReturn = new SuperHero();
		entityToReturn.setId(1);
		entityToReturn.setName("super");

		Gson gson = new Gson();
		String requestBodyDto = gson.toJson(dto);

		Mockito.when(service.save(entityToReturn)).thenReturn(1);

		try {
			mvc.perform(post("/api/superhero").contentType(MediaType.APPLICATION_JSON).content(requestBodyDto))
					.andExpect(status().isOk());
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Test
	void testUpdateSuperHero() {
		
		SuperHeroDto dto = new SuperHeroDto();
		dto.setId(1);
		dto.setName("super");

		SuperHero entityToReturn = new SuperHero();
		entityToReturn.setId(1);
		entityToReturn.setName("super");

		Gson gson = new Gson();
		String requestBodyDto = gson.toJson(dto);

		Mockito.when(service.update(entityToReturn)).thenReturn(1);
		Mockito.when(service.getById(Mockito.anyInt())).thenReturn(dto);

		try {
			mvc.perform(put("/api/superhero/{id}", 1).contentType(MediaType.APPLICATION_JSON).content(requestBodyDto))
					.andExpect(status().isOk());
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Test
	void testDeleteSuperHeroById() {
		
		try {
			mvc.perform(delete("/api/superhero/{id}", 1)).andExpect(status().isOk());
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Test
	void testDeleteAllSuperHeroes() {
		
		try {
			mvc.perform(delete("/api/superheroes")).andExpect(status().isOk());
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
