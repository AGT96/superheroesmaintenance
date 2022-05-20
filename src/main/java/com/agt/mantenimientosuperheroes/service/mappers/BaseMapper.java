package com.agt.mantenimientosuperheroes.service.mappers;

import org.mapstruct.Mapper;

import com.agt.mantenimientosuperheroes.service.data.dto.BaseDto;
import com.agt.mantenimientosuperheroes.service.data.entities.BaseEntity;

/**
 * Base interface for all mappers with methods to map entity to dto and viceversa.
 * It uses Java generics to provide facilities to develop with them.
 * Any mapper interface can extend from this class to inherit this methods and must be annotated
 * with the {@link Mapper} annotation to generate there implementations.
 * @author AGT96
 *
 * @param <E> Any entity that extends from {@link BaseEntity}.
 * @param <D> Any DTO (data transfer object) that extends from {@link BaseDto}.
 */
public interface BaseMapper<E extends BaseEntity, D extends BaseDto> {
	
	/**
	 * Maps a dto to entity.
	 * @param dto the dto to be converted.
	 * @return a entity converted from the dto.
	 */
	E toEntity(D dto);
	
	/**
	 * Maps a entity to dto.
	 * @param entity the entity to be converted.
	 * @return a dto converted from the entity;
	 */
	D toDto(E entity);
}
