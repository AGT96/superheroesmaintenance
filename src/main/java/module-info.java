module superheroesmaintenance {
	exports com.agt.mantenimientosuperheroes.config;

	exports com.agt.mantenimientosuperheroes.util;

	exports com.agt.mantenimientosuperheroes.controller;

	exports com.agt.mantenimientosuperheroes.service.mappers;
	exports com.agt.mantenimientosuperheroes.service.crud;
	exports com.agt.mantenimientosuperheroes.service.data.dto;
	exports com.agt.mantenimientosuperheroes.service.data.entities;
	exports com.agt.mantenimientosuperheroes.service.crud.impl;
	exports com.agt.mantenimientosuperheroes.service.crud.definition;
	exports com.agt.mantenimientosuperheroes.service.repository;

	exports com.agt.mantenimientosuperheroes;
	
	requires  org.hibernate.orm.core; // This unnamed  module is required to work with JPA entities.
	
	requires java.persistence;

	requires com.google.gson;

	requires org.mapstruct;
	
	requires org.mockito;
	
	requires org.slf4j;
	
	requires org.apache.tomcat.embed.core; // Add this module to Spring boot with java 11 modules 
	
	requires spring.beans;
	
	requires spring.boot;
	requires spring.boot.autoconfigure;
	
	requires spring.context;
	
	requires spring.core;
	
	requires spring.data.commons;
	requires spring.data.jpa;
	
	requires transitive spring.web;
	
	opens com.agt.mantenimientosuperheroes.controller to spring.core;
	opens com.agt.mantenimientosuperheroes to spring.core;
	opens com.agt.mantenimientosuperheroes.config to spring.core, org.junit.jupiter;
	opens com.agt.mantenimientosuperheroes.service.data.entities to spring.core, org.hibernate.orm.core;
	opens com.agt.mantenimientosuperheroes.service.crud.impl to spring.core;
}