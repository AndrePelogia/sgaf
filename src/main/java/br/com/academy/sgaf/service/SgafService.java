package br.com.academy.sgaf.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("sgaf") //http://localhost:8080/Sgaf/rest/sgaf
public class SgafService {
	@GET
	public String exibir() {
		return "Curso de Java";
	}
}
