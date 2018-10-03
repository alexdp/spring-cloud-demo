package com.essec.microservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Path("/")
@Scope("prototype")
@Service
public class DemoService {

	@GET
	@Path("/hello/{user}")
	@Produces({ MediaType.APPLICATION_JSON })
    public Response sayHello(@PathParam("user") String user) {
		String result = "Hello " + user;
		return Response.ok(result).build();
    }

}
