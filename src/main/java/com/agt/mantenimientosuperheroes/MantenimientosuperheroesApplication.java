package com.agt.mantenimientosuperheroes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Application main entry point.
 * Contains the main method to start the application.
 * @author AGT96
 */
@SpringBootApplication(scanBasePackages = {"com.agt.mantenimientosuperheroes"})
@EnableJpaRepositories
@EnableAutoConfiguration
public class MantenimientosuperheroesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MantenimientosuperheroesApplication.class, args);
	}

}
