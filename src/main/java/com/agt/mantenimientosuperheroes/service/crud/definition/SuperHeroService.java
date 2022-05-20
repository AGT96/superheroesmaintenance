package com.agt.mantenimientosuperheroes.service.crud.definition;

import com.agt.mantenimientosuperheroes.service.data.dto.SuperHeroDto;
import com.agt.mantenimientosuperheroes.service.data.entities.SuperHero;

import java.util.List;

import com.agt.mantenimientosuperheroes.service.crud.BaseDbService;

/**
 * Service definition for manage {@link SuperHero} entities.
 * inherits from {@link BaseDbService} to have the basic CRUD methods.
 * 
 * @author AGT96
 */
public interface SuperHeroService extends BaseDbService<SuperHero, SuperHeroDto> {
	
	/**
	 * Finds a {@link SuperHero} entities that starts with specific characters.
	 * 
	 * @param name the characters to find the entity
	 * @return a {@link List} with the entities that starts with the provided string.
	 */
	List<SuperHeroDto> getByNameContaining(String name);
	
}
