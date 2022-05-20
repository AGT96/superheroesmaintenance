package com.agt.mantenimientosuperheroes.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.agt.mantenimientosuperheroes.util.Constants;
import com.agt.mantenimientosuperheroes.util.MessageGenerator;

import com.agt.mantenimientosuperheroes.service.data.dto.ResponseMessage;
import com.agt.mantenimientosuperheroes.service.data.dto.SuperHeroDto;
import com.agt.mantenimientosuperheroes.service.data.entities.SuperHero;
import com.agt.mantenimientosuperheroes.service.crud.definition.SuperHeroService;
import static com.agt.mantenimientosuperheroes.service.mappers.SuperHeroesMapper.SUPER_HEROE_MAPPER_INSTANCE;

/**
 * The {@link SuperheroController} exposes the superheroes api to use their endpoints.
 * 
 * @author AGT96
 */
@RestController
@RequestMapping("/api")
public class SuperheroController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SuperheroController.class);

	@Autowired
	private SuperHeroService service;

	/**
	 * Retrieves all the {@link SuperHero} from the database.
	 * 
	 * @return a {@link ResponseEntity} with the {@link HttpStatus} operation status
	 *         and a {@link ResponseMessage}.
	 */
	@GetMapping("/superhero/all")
	public ResponseEntity<ResponseMessage> getAllSuperheroes() {
		LOGGER.info("Entering getAllSuperheroes method...");

		List<SuperHeroDto> heroes = new ArrayList<>();

		ResponseMessage resMsg;
		HttpStatus httpStatus;

		try {

			heroes = service.getAllContent();

			if (!heroes.isEmpty()) {

				resMsg = MessageGenerator.generateMessage(Constants.SUCCESS_MESSAGE, Constants.SEVERAL_ITEMS_MESSAGE,
						heroes);

				httpStatus = HttpStatus.OK;

				LOGGER.info("Data obtained, retriving...");

			} else {

				resMsg = MessageGenerator.generateMessage(Constants.NO_ITEMS_TO_SHOW_MESSAGE, Constants.NOTHING_TO_SHOW,
						heroes);

				httpStatus = HttpStatus.NO_CONTENT;

				LOGGER.info("No data obtained");
			}

		} catch (Exception e) {

			resMsg = MessageGenerator.generateMessage(Constants.EXCEPTION_OCURRED_MESSAGE + e.getMessage(),
					Constants.NOTHING_TO_SHOW, heroes);

			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

			LOGGER.error(Constants.EXCEPTION_OCURRED_MESSAGE, e);
		}

		return MessageGenerator.showResponse(resMsg, httpStatus);
	}

	/**
	 * Retrieves the existing {@link SuperHero} with the given id.
	 * 
	 * @param id the id to find the {@link SuperHero}
	 * @return a {@link ResponseEntity} with the {@link HttpStatus} operation status
	 *         and a {@link ResponseMessage}.
	 */
	@GetMapping("/superhero/{id}")
	public ResponseEntity<ResponseMessage> getById(@PathVariable("id") Integer id) {

		LOGGER.info("Entering getById method...");

		List<SuperHeroDto> heroes = new ArrayList<>();

		ResponseMessage resMsg;
		HttpStatus httpStatus;

		try {

			Optional<SuperHeroDto> superHeroData = Optional.ofNullable(service.getById(id));

			if (superHeroData.isPresent()) {

				heroes.add(superHeroData.get());

				resMsg = MessageGenerator.generateMessage(Constants.SUCCESS_MESSAGE, id.toString(), heroes);

				httpStatus = HttpStatus.OK;

				LOGGER.info("Data obtained, retriving...");

			} else {

				resMsg = MessageGenerator.generateMessage(Constants.OBJECT_NOT_FOUND_MESSAGE, id.toString(), heroes);

				httpStatus = HttpStatus.NO_CONTENT;

				LOGGER.info("No data obtained");
			}

		} catch (Exception e) {

			resMsg = MessageGenerator.generateMessage(Constants.EXCEPTION_OCURRED_MESSAGE + e.getMessage(),
					Constants.NOTHING_TO_SHOW, heroes);

			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

			LOGGER.error(Constants.EXCEPTION_OCURRED_MESSAGE, e);
		}

		return MessageGenerator.showResponse(resMsg, httpStatus);
	}

	/**
	 * Retrieves the existing superheroes with the given name.
	 * 
	 * @param title the title to find the {@link SuperHero}.
	 * @return a {@link ResponseEntity} with the {@link HttpStatus} operation status
	 *         and a {@link ResponseMessage}.
	 */
	@GetMapping("/superhero/byName/{name}")
	public ResponseEntity<ResponseMessage> getByName(@PathVariable("name") String name) {

		LOGGER.info("Entering getByName method...");

		List<SuperHeroDto> superHeroLst = new ArrayList<>();

		ResponseMessage resMsg;
		HttpStatus httpStatus;

		try {

			Optional<List<SuperHeroDto>> superHeroesData = Optional.ofNullable(service.getByNameContaining(name));

			superHeroLst = superHeroesData.isPresent() ? superHeroesData.get() : new ArrayList<>(); // If is present,
																									// get data else
																									// create new empty
																									// arrayList.

			if (!superHeroLst.isEmpty()) {

				resMsg = MessageGenerator.generateMessage(Constants.SUCCESS_MESSAGE, Constants.SEVERAL_ITEMS_MESSAGE,
						superHeroLst);

				httpStatus = HttpStatus.OK;

				LOGGER.info("Data obtained, retriving...");

			} else {

				resMsg = MessageGenerator.generateMessage(Constants.OBJECT_NOT_FOUND_MESSAGE, name, superHeroLst);

				httpStatus = HttpStatus.NO_CONTENT;

				LOGGER.info("No data obtained");
			}

		} catch (Exception e) {

			resMsg = MessageGenerator.generateMessage(Constants.EXCEPTION_OCURRED_MESSAGE + e.getMessage(),
					Constants.NOTHING_TO_SHOW, superHeroLst);

			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

			LOGGER.error(Constants.EXCEPTION_OCURRED_MESSAGE, e);
		}

		return MessageGenerator.showResponse(resMsg, httpStatus);
	}

	/**
	 * Creates a new {@link SuperHero} with the {@link SuperHeroDto} json body.
	 * 
	 * @param dto the body with the {@link SuperHeroDto} json body params.
	 * @return a {@link ResponseEntity} with the {@link HttpStatus} operation status
	 *         and a {@link ResponseMessage}.
	 */
	@PostMapping("/superhero")
	public ResponseEntity<ResponseMessage> createSuperHero(@RequestBody SuperHeroDto dto) {

		LOGGER.info("Entering createSuperHero method...");

		ResponseMessage resMsg;
		HttpStatus httpStatus;

		try {

			var newId = service.save(SUPER_HEROE_MAPPER_INSTANCE.toEntity(dto));

			resMsg = MessageGenerator.generateMessage(Constants.SUCCESS_MESSAGE, dto.getName(), newId);

			httpStatus = HttpStatus.OK;

			LOGGER.info("Superhero created successfully");

		} catch (Exception e) {

			resMsg = MessageGenerator.generateMessage(Constants.EXCEPTION_OCURRED_MESSAGE + e.getMessage(),
					Constants.NOTHING_TO_SHOW, 0);

			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

			LOGGER.error(Constants.EXCEPTION_OCURRED_MESSAGE, e);
		}

		return MessageGenerator.showResponse(resMsg, httpStatus);
	}

	/**
	 * Updates a specific {@link SuperHero}.
	 * 
	 * @param id  the id to update a specific {@link SuperHero}
	 * @param dto the {@link SuperHeroDto} json body to modify {@link SuperHero}
	 *            parameters.
	 * @return a {@link ResponseEntity} with the {@link HttpStatus} operation status
	 *         and a {@link ResponseMessage}.
	 */
	@PutMapping("/superhero/{id}")
	public ResponseEntity<ResponseMessage> updateSuperHero(@PathVariable("id") Integer id,
			@RequestBody SuperHeroDto dto) {

		LOGGER.info("Entering updateSuperHero method...");

		Integer updatedEntityId = 0;

		ResponseMessage resMsg;
		HttpStatus httpStatus;

		try {

				updatedEntityId = service.update(SUPER_HEROE_MAPPER_INSTANCE.toEntity(dto));

				resMsg = MessageGenerator.generateMessage(Constants.SUCCESS_MESSAGE, id.toString(), updatedEntityId);

				httpStatus = HttpStatus.OK;

				LOGGER.info("Superhero updated successfully");

		} catch (Exception e) {

			resMsg = MessageGenerator.generateMessage(Constants.EXCEPTION_OCURRED_MESSAGE + e.getMessage(),
					Constants.NOTHING_TO_SHOW, updatedEntityId);

			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			
			LOGGER.info("Cannot update Superhero");

			LOGGER.error(Constants.EXCEPTION_OCURRED_MESSAGE, e);
		}

		return MessageGenerator.showResponse(resMsg, httpStatus);
	}

	/**
	 * Updates a specific {@link SuperHero} with the given id and
	 * {@link SuperHeroDto} json body.
	 * 
	 * @param id  the id to update a specific {@link SuperHero}
	 * @param dto the {@link SuperHeroDto} json body to modify {@link SuperHero}
	 *            parameters.
	 * @return a {@link ResponseEntity} with the {@link HttpStatus} operation status
	 *         and a {@link ResponseMessage}.
	 */
	@PatchMapping("/superhero/{id}")
	public ResponseEntity<ResponseMessage> patchSuperHeroe(@PathVariable("id") Integer id,
			@RequestBody SuperHeroDto dto) {

		LOGGER.info("Entering updateSuperHero method...");

		Integer updatedEntityId = 0;

		ResponseMessage resMsg;
		HttpStatus httpStatus;

		try {

			Optional<SuperHeroDto> superheroData = Optional.ofNullable(service.getById(id));

			if (superheroData.isPresent()) {

				SuperHeroDto superheroDtoFound = superheroData.get();

				updatedEntityId = service.update(SUPER_HEROE_MAPPER_INSTANCE.toEntity(superheroDtoFound));

				resMsg = MessageGenerator.generateMessage(Constants.SUCCESS_MESSAGE, id.toString(), updatedEntityId);

				httpStatus = HttpStatus.OK;

				LOGGER.info("Superhero updated successfully");

			} else {

				resMsg = MessageGenerator.generateMessage(Constants.OBJECT_NOT_FOUND_MESSAGE, id.toString(),
						updatedEntityId);

				httpStatus = HttpStatus.NO_CONTENT;

				LOGGER.info("Cannot update Superhero");
			}

		} catch (Exception e) {

			resMsg = MessageGenerator.generateMessage(Constants.EXCEPTION_OCURRED_MESSAGE + e.getMessage(),
					Constants.NOTHING_TO_SHOW, updatedEntityId);

			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

			LOGGER.error(Constants.EXCEPTION_OCURRED_MESSAGE, e);
		}

		return MessageGenerator.showResponse(resMsg, httpStatus);
	}

	/**
	 * Deletes a specific {@link SuperHero} with the given id.
	 * 
	 * @param id the id to delete the {@link SuperHero}.
	 * @return a {@link ResponseEntity} with the {@link HttpStatus} operation status
	 *         and a {@link ResponseMessage}.
	 */
	@DeleteMapping("/superhero/{id}")
	public ResponseEntity<ResponseMessage> deleteSuperHeroById(@PathVariable("id") Integer id) {
		
		LOGGER.info("Entering deleteSuperHeroById method...");

		ResponseMessage resMsg;
		HttpStatus httpStatus;

		try {

			boolean isDeleted = service.deleteById(id);

			if (isDeleted) {
				
				resMsg = MessageGenerator.generateMessage(Constants.SUCCESS_MESSAGE, id.toString(), new ArrayList<>());

				httpStatus = HttpStatus.OK;

				LOGGER.info("Superhero deleted successfully");
				
			} else {
				
				throw new IllegalArgumentException(Constants.INVALID_ID);
			}

		} catch (Exception e) {
			
			resMsg = MessageGenerator.generateMessage(Constants.EXCEPTION_OCURRED_MESSAGE + e.getMessage(),
					Constants.NOTHING_TO_SHOW, new ArrayList<>());

			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

			LOGGER.error(Constants.EXCEPTION_OCURRED_MESSAGE, e);
		}

		return MessageGenerator.showResponse(resMsg, httpStatus);
	}

	/**
	 * Deletes all the {@link SuperHero} from the database.
	 * 
	 * @return a {@link ResponseEntity} with the {@link HttpStatus} operation status
	 *         and a {@link ResponseMessage}.
	 */
	@DeleteMapping("/superheroes")
	public ResponseEntity<ResponseMessage> deleteAllSuperheroes() {
		
		LOGGER.info("Entering deleteAllSuperheroes method...");

		ResponseMessage resMsg;
		HttpStatus httpStatus;

		try {

			service.deleteAll();

			resMsg = MessageGenerator.generateMessage(Constants.SUCCESS_MESSAGE, Constants.ALL_ITEMS_DELETED,
					new ArrayList<>());

			httpStatus = HttpStatus.OK;
			LOGGER.info("All Superheroes deleted successfully");

		} catch (Exception e) {
			
			resMsg = MessageGenerator.generateMessage(Constants.EXCEPTION_OCURRED_MESSAGE + e.getMessage(),
					Constants.NOTHING_TO_SHOW, new ArrayList<>());

			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

			LOGGER.error(Constants.EXCEPTION_OCURRED_MESSAGE, e);
		}

		return MessageGenerator.showResponse(resMsg, httpStatus);
	}

}
