package com.essec.microservices;

import java.io.IOException;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.springframework.context.annotation.Configuration;

@Configuration
@ApplicationPath("/")
public class JerseyResourceConfig extends ResourceConfig {

	public JerseyResourceConfig() {
		register(CORSResponseFilter.class);
		register(RequestContextFilter.class);
		register(JacksonFeature.class);
		packages(true, this.getClass().getPackage().getName());

	}

	public static class CORSResponseFilter implements ContainerResponseFilter {
		public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {

			MultivaluedMap<String, Object> headers = responseContext.getHeaders();
			headers.add("Access-Control-Allow-Origin", "*");
			headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
			headers.add("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, X-Codingpedia");
		}
	}

}
