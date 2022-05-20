package com.agt.mantenimientosuperheroes.service.crud.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.agt.mantenimientosuperheroes.service.data.dto.SuperHeroDto;
import com.agt.mantenimientosuperheroes.service.data.entities.SuperHero;

import static com.agt.mantenimientosuperheroes.service.mappers.SuperHeroesMapper.SUPER_HEROE_MAPPER_INSTANCE;

import com.agt.mantenimientosuperheroes.service.crud.definition.SuperHeroService;
import com.agt.mantenimientosuperheroes.service.repository.SuperHeroeRepository;

import com.agt.mantenimientosuperheroes.util.Constants;

/**
 * The {@link SuperHeroeServiceImpl} contains the CRUD implementations methods.
 * @author AGT96
 */
@Service
public final class SuperHeroeServiceImpl implements SuperHeroService {
	
	@Autowired
	SuperHeroeRepository repo;

	@Override
	public List<SuperHeroDto> getAllContent() {
		
		List<SuperHeroDto> dtoLst = new ArrayList<>();
		
		var entityLst = repo.findAll();
		
		dtoLst = entityLst.stream().map(SUPER_HEROE_MAPPER_INSTANCE::toDto).collect(Collectors.toList());
		
		return dtoLst;
	}
	
	@Override
	public SuperHeroDto getById(Integer id) {
		
		return SUPER_HEROE_MAPPER_INSTANCE.toDto(repo.getReferenceById(id));
	}
	
	@Override
	public List<SuperHeroDto> getByNameContaining(String name){
		
		List<SuperHeroDto> dtoLst = new ArrayList<>();
		
		var entityLst = repo.findByNameContaining(name);
		
		dtoLst = entityLst.stream().map(SUPER_HEROE_MAPPER_INSTANCE::toDto).collect(Collectors.toList());
		
		return dtoLst;
	}

	@Override
	public Integer save(SuperHero entity) {
		
		SuperHero entitySaved = repo.save(entity);
		
		return entitySaved.getId();
	}

	@Override
	public Integer update(SuperHero entity) {
		
		SuperHero entityUpdated = null;
		
		SuperHero entityFromDb = repo.getReferenceById(entity.getId());
		
		if(entityFromDb != null) {
			
			entityFromDb.setName(entity.getName());
			entityFromDb.setPowers(entity.getPowers());
			entityFromDb.setCompany(entity.getCompany());
			entityFromDb.setComics(entity.getComics());
			
			entityUpdated = repo.save(entityFromDb);
		}
		
		return entityUpdated.getId();
	}

	@Override
	public Integer deleteById(Integer id) {
		
		if(id != null) {
			
			repo.deleteById(id);
			
		} else {
			
			throw new IllegalArgumentException(Constants.ID_MUST_NOT_BE_NULL);
		}
		
		return id;
	}

	@Override
	public boolean deleteAll() {
		
		repo.deleteAll();
		
		return true;
	}
}
