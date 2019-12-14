package pt.cuong.rest.ex;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pt.cuong.rest.ex.model.Person;
import pt.cuong.rest.ex.service.PersonService;

@Path("persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonsResource {

	@GET
	public List<Person> getPersons() {
		System.out.println("get list person");
		return PersonService.getPersons();	
	}
	
	@POST
	public List<Person> createPerson(Person person) {
		System.out.println("create person");
		PersonService.createPerson(person);
		return PersonService.getPersons();
	}
	
	@Path("/{id}")
	@PUT
	public List<Person> updatePerson(@PathParam("id") long personId, Person person) {
		person.setId(personId);
		PersonService.updatePerson(person);
		return PersonService.getPersons();
	}
	
	@Path("/{id}")
	@DELETE
	public List<Person> deletePerson(@PathParam("id") long personId) {
		PersonService.deletePerson(personId);
		return PersonService.getPersons();
	}
}
