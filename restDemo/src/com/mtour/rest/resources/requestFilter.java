package com.mtour.rest.resources;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

public class requestFilter implements ContainerRequestFilter{

	@Override
	public ContainerRequest filter(ContainerRequest arg0) {
		// TODO Auto-generated method stub
		
		throw new WebApplicationException(
                Response.status(Status.INTERNAL_SERVER_ERROR).build());
		
	}
	
}
