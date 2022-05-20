package com.agt.mantenimientosuperheroes.service.crud;

import java.util.List;

import com.agt.mantenimientosuperheroes.service.data.dto.BaseDto;
import com.agt.mantenimientosuperheroes.service.data.entities.BaseEntity;

/**
 * Base methods to implement services to manage data in sqlite.
 * It uses Java generics to provide facilities to develop them.
 * @author AGT96
 *
 * @param <E> Any entity that extends from {@link BaseEntity}.
 * @param <D> Any DTO (data transfer object) that extends from {@link BaseDto}.
 */
public interface BaseDbService <E extends BaseEntity, D extends BaseDto> {
	
	/**
	 * Get all content from the database, convert to dto and return a list of
	 * them.
	 */
	List<D> getAllContent();
	
	/**
	 * Get a entity by id and return as dto.
	 * @param id the id of the entity.
	 * @return a dto converted of his entity if found.
	 */
	D getById(Integer id);
	
	/**
	 * Saves the entity to database.
	 * 
	 * @param entity the entity to be save.
	 * @return the id of the entity if the operation was completed successfully, otherwise false.
	 */
	Integer save(E entity);
	
	/**
	 * Updates a existing entity from the database.
	 * 
	 * @param entity the entity to be updated.
	 * @return the id of the entity the operation was completed successfully, otherwise false.
	 */
	Integer update(E entity);
	
	/**
	 * Deletes a existing entity from the database.
	 * 
	 * @param id the entity id to be deleted.
	 * @return true if the operation was completed successfully, otherwise false.
	 * @throws IllegalArgumentException if the id is null.
	 */
	boolean deleteById(Integer id) throws IllegalArgumentException;
	
	/**
	 * Deletes all content from the database.
	 * 
	 * @return true if the operation was completed successfully, otherwise false.
	 */
	boolean deleteAll();
}
