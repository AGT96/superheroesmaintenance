package com.agt.mantenimientosuperheroes.config;

import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.agt.mantenimientosuperheroes.controller.SuperheroController;

import com.agt.mantenimientosuperheroes.service.crud.definition.SuperHeroService;

/**
 * Base class with the needed annotations, mocks and services for the controllers tests.
 * @author alvaro.gamir
 *
 */
@AutoConfigureMockMvc
@ContextConfiguration(classes = {SuperheroController.class, SuperHeroService.class})
@WebMvcTest
public class ControllerConfigTest {
	
	/**
	 * For testing controllers endpoints, the {@link MockMvc} is used to test
	 * it and can execute HTTP methods.
	 */
	@Autowired
	protected MockMvc mvc;
	
	/**
	 * In the controllers test is necessary to mock the services. You can define 
	 * the mock behavior in the test method with the {@link Mockito} api.
	 */
	@MockBean
	protected SuperHeroService service;
}
