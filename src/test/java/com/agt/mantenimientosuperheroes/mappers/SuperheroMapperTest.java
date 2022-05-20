package com.agt.mantenimientosuperheroes.mappers;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import com.agt.mantenimientosuperheroes.service.data.dto.SuperHeroDto;
import com.agt.mantenimientosuperheroes.service.data.entities.SuperHero;
import static com.agt.mantenimientosuperheroes.service.mappers.SuperHeroesMapper.SUPER_HEROE_MAPPER_INSTANCE;

class SuperheroMapperTest {

	private PodamFactory podamFactory = new PodamFactoryImpl();

	@Test
	void testMapEntityToDto() {
		SuperHero e = podamFactory.manufacturePojo(SuperHero.class);
		
		SuperHeroDto d = SUPER_HEROE_MAPPER_INSTANCE.toDto(e);
		
		assertNotNull(d);
	}
	
	@Test
	void testMaptDtoToEntity() {
		SuperHeroDto d = podamFactory.manufacturePojo(SuperHeroDto.class);
		
		SuperHero e = SUPER_HEROE_MAPPER_INSTANCE.toEntity(d);
		
		assertNotNull(e);
	}
}
