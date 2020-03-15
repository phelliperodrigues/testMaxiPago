package com.phellipe.distanceCities.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class CityException extends WebApplicationException {

	private static final long serialVersionUID = 1L;
	
	public CityException() {
		super(Response.status(404).entity("City not Found").build());
	}
	
	

}
