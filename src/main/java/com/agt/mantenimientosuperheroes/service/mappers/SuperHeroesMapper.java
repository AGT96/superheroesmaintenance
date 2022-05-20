package com.agt.mantenimientosuperheroes.service.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.agt.mantenimientosuperheroes.data.dto.SuperHeroeDto;
import com.agt.mantenimientosuperheroes.data.entities.SuperHeroe;

/**
 * This interface uses the mapstruct api to provide implementations for mapping methods, that can be
 * found in target/generated-sources/annotations when compiling it.
 * 
 * In this case maps from {@link SuperHeroeDto} to {@link SuperHeroe} entity and vice versa
 * @author AGT96
 */
@Mapper
public interface SuperHeroesMapper extends BaseMapper<SuperHeroe, SuperHeroeDto> {
	
	SuperHeroesMapper SUPER_HEROE_MAPPER_INSTANCE = Mappers.getMapper(SuperHeroesMapper.class);
}
