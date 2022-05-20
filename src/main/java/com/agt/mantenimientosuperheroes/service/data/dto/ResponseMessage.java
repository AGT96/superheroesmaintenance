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
	
	public ResponseMessage(String message, String optionalParameter, List<SuperHeroDto> superheroeDtoLst) {
		this.message = message;
		this.optionalParameter = optionalParameter;
		this.items = superheroeDtoLst;
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

	public List<SuperHeroDto> getBookLst() {
		return items;
	}

	public void setBookLst(List<SuperHeroDto> superheroeDtoLst) {
		this.items = superheroeDtoLst;
	}

	@Override
	public String toString() {
		return "ResponseMessage [message=" + message + ", optionalParameter=" + optionalParameter + ", items=" + items
				+ "]";
	}
}
