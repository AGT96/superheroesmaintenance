package com.agt.mantenimientosuperheroes.service;

import java.util.List;

import com.agt.mantenimientosuperheroes.data.dto.BaseDto;
import com.agt.mantenimientosuperheroes.data.entities.BaseEntity;

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
	 * Saves the content to database.
	 * 
	 * @param entityList The list of entities, may contain one or more elements.
	 * @return true if the operation was completed successfully, otherwise false.
	 */
	boolean save(List<E> entityList);
	
	/**
	 * Updates a existing entity from the database.
	 * 
	 * @param entity the entity to be updated.
	 * @return true if the operation was completed successfully, otherwise false.
	 */
	boolean update(E entity);
	
	/**
	 * Deletes a existing entity from the database.
	 * 
	 * @param entity the entity to be deleted.
	 * @return true if the operation was completed successfully, otherwise false.
	 */
	boolean delete(E entity);
	
	/**
	 * Deletes all content from the database.
	 * 
	 * @return true if the operation was completed successfully, otherwise false.
	 */
	boolean deleteAll();
}
