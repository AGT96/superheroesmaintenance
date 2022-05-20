package com.agt.mantenimientosuperheroes.util;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.agt.mantenimientosuperheroes.service.data.dto.ResponseMessage;
import com.agt.mantenimientosuperheroes.service.data.dto.SuperHeroDto;


/**
 * The utility {@link MessageGenerator} contains methods to generates a {@link ResponseMessage} to report the operations
 * of the application, used to create a {@link ResponseEntity} with the HTTP status.
 * @author AGT96
 *
 */
public final class MessageGenerator {
	
	private MessageGenerator() {
		throw new IllegalStateException("Cannot instantiate this utility class" + MessageGenerator.class.getName());
	}
	
	/**
	 * Creates a new {@link ResponseMessage} instance with a given message, optionalParameter a bookLst.
	 * @param message the message to report.
	 * @param optionalParameter a name or id of determinate object.
	 * @param bookLst the {@link List} of {@link BookDto} to show in the {@link ResponseEntity}.
	 * @return the {@link ResponseMessage} with the given parameters.
	 */
	public static ResponseMessage generateMessage(String message, String optionalParameter, List<SuperHeroDto> superheroesDtoLst) {
		return new ResponseMessage(message, optionalParameter, superheroesDtoLst);
	}
	
	/**
	 * Returns a response entity with a given ResponseMessage and HttpStatus.
	 * @param resMessage the ResponseMessage to show
	 * @param httpStatus the http status operation.
	 * @return a new {@link ResponseEntity} with a {@link ResponseMessage} and {@link HttpStatus}.
	 */
	public static ResponseEntity<ResponseMessage> showResponse(ResponseMessage resMessage, HttpStatus httpStatus){
		return new ResponseEntity<>(resMessage, httpStatus); 
	}
}