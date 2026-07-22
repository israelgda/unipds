package israelgda.resources;

import israelgda.entities.Person;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
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
}
