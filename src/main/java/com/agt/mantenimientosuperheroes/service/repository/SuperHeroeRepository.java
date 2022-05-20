package com.agt.mantenimientosuperheroes.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agt.mantenimientosuperheroes.data.entities.SuperHeroe;

/**
 * The {@link SuperHeroeRepository} contains the basic {@link SuperHeroe} JPA repositories methods.
 * @author AGT96
 */
@Repository
public interface SuperHeroeRepository extends JpaRepository<SuperHeroe, Integer> {
	
	/**
	 * Finds a {@link SuperHeroe} entities that starts on characters.
	 * This is the the same as in sql:
	 * 
	 * SELECT name FROM superheroes WHERE name LIKE '%man%';
	 * @param name the characters to find the entity
	 * @return a {@link List} with the entity that starts with the provided string.
	 */
	List<SuperHeroe> findByNameContaining(String name);

}
