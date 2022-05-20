package com.agt.mantenimientosuperheroes.service.data.dto;

import java.util.List;

/**
 * The {@link ResponseMessage} is used to report the application operations.
 * @author AGT96
 *
 */
public class ResponseMessage {
	
	private String message;
	
	private String optionalParameter;
	
	private List<SuperHeroDto> items;
	
	private Integer entityId;
	
	/**
	 * Creates a new instance of {@link ResponseMessage} with a message, optionalParameter and superheroedtoLst
	 * @param message the message to show in the response
	 * @param optionalParameter the optional parameter to show in the response.
	 * @param superheroeDtoLst the list of {@link SuperHeroDto} to show in the response.
	 */
	public ResponseMessage(String message, String optionalParameter, List<SuperHeroDto> superheroeDtoLst) {
		this.message = message;
		this.optionalParameter = optionalParameter;
		this.items = superheroeDtoLst;
	}
	
	/**
	 * Creates a new instance of {@link ResponseMessage} with a message, optionalParameter and superheroedtoLst
	 * @param message the message to show in the response
	 * @param optionalParameter the optional parameter to show in the response.
	 * @param entityId the id of the entity saved or updated.
	 */
	public ResponseMessage(String message, String optionalParameter, Integer entityId) {
		this.message = message;
		this.optionalParameter = optionalParameter;
		this.entityId = entityId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getOptionalParameter() {
		return optionalParameter;
	}

	public void setOptionalParameter(String optionalParameter) {
		this.optionalParameter = optionalParameter;
	}

	public List<SuperHeroDto> getSuperheroLst() {
		return items;
	}

	public void setSuperheroLst(List<SuperHeroDto> superheroeDtoLst) {
		this.items = superheroeDtoLst;
	}
	
	public Integer getEntityId() {
		return entityId;
	}

	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	@Override
	public String toString() {
		return "ResponseMessage = message = " + message + ", optionalParameter = " + optionalParameter + ", items = " + items
				+ "entityId = " + entityId;
	}
}
