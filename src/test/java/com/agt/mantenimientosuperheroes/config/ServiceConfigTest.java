package com.agt.mantenimientosuperheroes.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.agt.mantenimientosuperheroes.service.crud.definition.SuperHeroService;
import com.agt.mantenimientosuperheroes.service.repository.SuperHeroeRepository;

/**
 * Base class with the needed annotations, mocks and repositories for the service tests.
 * @author alvaro.gamir
 *
 */
@SpringBootTest
public class ServiceConfigTest {
	
	/**
	 * In the services test, a service is autowired to execute their actions, only
	 * the repositories are mocked.
	 */
	@Autowired
	protected SuperHeroService service;
	
	/**
	 * To simulate database operations, the repositories must be mocked. You can define its behavior in
	 * the test methods.
	 */
	@MockBean
	protected SuperHeroeRepository repository;
}
