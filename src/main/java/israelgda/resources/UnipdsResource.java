package israelgda.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/unipds")
public class UnipdsResource {

    @GET
    public String getUnipds() {
        return "Hello from UnipdsResource";
    }
}
