package com.agt.mantenimientosuperheroes.service.crud.definition;

import com.agt.mantenimientosuperheroes.service.data.dto.SuperHeroDto;
import com.agt.mantenimientosuperheroes.service.data.entities.SuperHero;

import com.agt.mantenimientosuperheroes.service.crud.BaseDbService;

/**
 * Service definition for manage {@link SuperHero} entities.
 * @author AGT96
 */
public interface SuperHeroService extends BaseDbService<SuperHero, SuperHeroDto> {}
