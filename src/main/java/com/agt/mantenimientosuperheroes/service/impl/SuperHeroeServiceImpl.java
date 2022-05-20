package com.agt.mantenimientosuperheroes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agt.mantenimientosuperheroes.data.dto.SuperHeroeDto;
import com.agt.mantenimientosuperheroes.data.entities.SuperHeroe;

import com.agt.mantenimientosuperheroes.service.BaseDbService;
import com.agt.mantenimientosuperheroes.service.repository.SuperHeroeRepository;

/**
 * The {@link SuperHeroeServiceImpl} contains the CRUD implementations methods.
 * @author AGT96
 */
@Service
public final class SuperHeroeServiceImpl implements BaseDbService<SuperHeroe, SuperHeroeDto> {
	
	//TODO: Complete this class
	
	@Autowired
	SuperHeroeRepository repo;

	@Override
	public List<SuperHeroeDto> getAllContent() {
		return null;
	}

	@Override
	public boolean save(List<SuperHeroe> entityList) {
		return false;
	}

	@Override
	public boolean update(SuperHeroe entity) {
		return false;
	}

	@Override
	public boolean delete(SuperHeroe entity) {
		return false;
	}

	@Override
	public boolean deleteAll() {
		return false;
	}
}
