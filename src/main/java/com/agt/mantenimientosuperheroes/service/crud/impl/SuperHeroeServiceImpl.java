package com.agt.mantenimientosuperheroes.service.crud.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.agt.mantenimientosuperheroes.data.dto.SuperHeroeDto;
import com.agt.mantenimientosuperheroes.data.entities.SuperHeroe;

import static com.agt.mantenimientosuperheroes.service.mappers.SuperHeroesMapper.SUPER_HEROE_MAPPER_INSTANCE;

import com.agt.mantenimientosuperheroes.service.crud.BaseDbService;
import com.agt.mantenimientosuperheroes.service.repository.SuperHeroeRepository;

import com.agt.mantenimientosuperheroes.util.Constants;

/**
 * The {@link SuperHeroeServiceImpl} contains the CRUD implementations methods.
 * @author AGT96
 */
@Service
public final class SuperHeroeServiceImpl implements BaseDbService<SuperHeroe, SuperHeroeDto> {
	
	@Autowired
	SuperHeroeRepository repo;

	@Override
	public List<SuperHeroeDto> getAllContent() {
		
		List<SuperHeroeDto> dtoLst = new ArrayList<>();
		
		var entityLst = repo.findAll();
		
		dtoLst = entityLst.stream().map(SUPER_HEROE_MAPPER_INSTANCE::toDto).collect(Collectors.toList());
		
		return dtoLst;
	}
	
	@Override
	public SuperHeroeDto getById(Integer id) {
		
		return SUPER_HEROE_MAPPER_INSTANCE.toDto(repo.getReferenceById(id));
	}

	@Override
	public Integer save(SuperHeroe entity) {
		
		SuperHeroe entitySaved = repo.save(entity);
		
		return entitySaved.getId();
	}

	@Override
	public Integer update(SuperHeroe entity) {
		
		SuperHeroe entityUpdated = null;
		
		SuperHeroe entityFromDb = repo.getReferenceById(entity.getId());
		
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
	public boolean delete(Integer id) {
		
		boolean isDeleted = false;
		
		if(id != null) {
			
			repo.deleteById(id);
			
			isDeleted = true;
			
		} else {
			
			throw new IllegalArgumentException(Constants.ID_MUST_NOT_BE_NULL);
		}
		
		return isDeleted;
	}

	@Override
	public boolean deleteAll() {
		
		repo.deleteAll();
		
		return true;
	}
}
