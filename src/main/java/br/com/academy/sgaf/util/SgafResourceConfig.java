package br.com.academy.sgaf.util;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("rest") // http://localhost:8080/Sgaf/rest
public class SgafResourceConfig extends ResourceConfig {
	public SgafResourceConfig() {
		packages("br.com.academy.sgaf.service");
	}
}
