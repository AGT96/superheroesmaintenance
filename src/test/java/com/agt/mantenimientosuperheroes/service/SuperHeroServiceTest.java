package com.agt.mantenimientosuperheroes.service;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import com.agt.mantenimientosuperheroes.config.ServiceConfigTest;

import com.agt.mantenimientosuperheroes.service.data.dto.SuperHeroDto;
import com.agt.mantenimientosuperheroes.service.data.entities.SuperHero;

class SuperHeroServiceTest extends ServiceConfigTest {

	@Test
	void testFindByNameContaining() {

		SuperHero entityToReturn = new SuperHero();
		entityToReturn.setId(1);
		entityToReturn.setName("super");
		
		List<SuperHero> superHerodtoLst = new ArrayList<>();
		superHerodtoLst.add(entityToReturn);


		Mockito.when(repository.findByNameContaining(Mockito.anyString())).thenReturn(superHerodtoLst); // Define the repository mock behavior.

		List<SuperHeroDto> superHeroLstReturned = service.getByNameContaining("Super"); // test the repositories and services.
		assertFalse(superHeroLstReturned.isEmpty()); // assert that the condition is evaluated as expected.
	}

	@Test
	void testFindSuperheroById() {
		SuperHeroDto dto = new SuperHeroDto();
		dto.setId(1);
		dto.setName("super");

		SuperHero entityToReturn = new SuperHero();
		entityToReturn.setId(1);
		entityToReturn.setName("super");

		Mockito.when(repository.getReferenceById(Mockito.anyInt())).thenReturn(entityToReturn);

		SuperHeroDto dtoReturned = service.getById(1);

		assertNotNull(dtoReturned);
	}

	@Test
	void testFindAllBooks() {
		SuperHero entity = new SuperHero();
		entity.setId(1);
		entity.setName("super");
		
		List<SuperHero> superHeroLst = new ArrayList<>();
		superHeroLst.add(entity);

		Mockito.when(repository.findAll()).thenReturn(superHeroLst);

		List<SuperHeroDto> superHeroDtoReturnLst = service.getAllContent();

		assertFalse(superHeroDtoReturnLst.isEmpty());
	}

	@Test
	void testSave() {

		SuperHero entity = new SuperHero();
		entity.setId(1);
		entity.setName("super");

		Mockito.when(repository.save(Mockito.any(SuperHero.class))).thenReturn(entity);

		Integer entityIdSaved = service.save(entity);

		assertAll(() -> assertNotNull(entityIdSaved));
	}
	
	@Test
	void testUpdate() {

		SuperHero entity = new SuperHero();
		entity.setId(1);
		entity.setName("super");

		Mockito.when(repository.save(Mockito.any(SuperHero.class))).thenReturn(entity);
		Mockito.when(repository.getReferenceById(Mockito.anyInt())).thenReturn(entity);

		Integer idFromTheUpdatedDto = service.update(entity);

		assertAll(() -> assertNotNull(idFromTheUpdatedDto));
	}

	@Test
	void testDeleteById() {
		
		Integer id = 1;
		
		Assertions.assertDoesNotThrow(() -> service.deleteById(id));
	}

	@Test
	void testDeleteAllSuperHeroes(){
		
		Assertions.assertDoesNotThrow(() -> service.deleteAll());
	}

}
