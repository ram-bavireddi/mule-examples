package org.ram.mule.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.ram.mule.jersey.model.Person;

@Path("/jersey")
public class JerseyService {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Person getPerson() {
		Person person = new Person();
		person.setName("Ram");
		person.setAddress("KPHB 9th PHASE, HYDERABAD, INDIA");
		person.setSex("Male");
		return person;
	}
}
