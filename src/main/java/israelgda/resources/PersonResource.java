package israelgda.resources;

import israelgda.entities.Person;
import israelgda.entities.dtos.PersonDTO;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {

    @GET
    public List<Person> getPerson() {
        return Person.listAll();
    }

    @POST
    @Transactional
    public Person createPerson(Person person) {
        person.id = null;
        person.persist();
        return person;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Person updatePerson(
            Integer id,
            PersonDTO person
    ){
        Person personFound = Person.findById(id);
        if (personFound == null) {
            throw new RuntimeException("Person not found");
        } else {
            personFound.name = person.getName();
            personFound.age = person.getAge();
            personFound.persist();
        }
        return Person.findById(id);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void deletePerson(Integer id) {
        Person personFound = Person.findById(id);
        if (personFound == null) {
            throw new RuntimeException("Person not found");
        } else {
            personFound.delete();
        }
    }
}
