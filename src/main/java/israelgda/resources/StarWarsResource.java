package israelgda.resources;

import israelgda.clients.StarwarsService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/starwars")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StarWarsResource {

    @RestClient
    StarwarsService starwarsService;

    @GET
    @Path("/starships")
    public String getStartships() {
        return starwarsService.getStarwarsShips();
    }

}
