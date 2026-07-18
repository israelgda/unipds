package israelgda.clients;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.time.temporal.ChronoUnit;

@RegisterRestClient(baseUri = "https://swapi.info/api/")
public interface StarwarsService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("starships")
    @Timeout(
        value = 3,
        unit = ChronoUnit.SECONDS
    )
    @Fallback(
            fallbackMethod = "getStarwarsShipsFallback"
    )
    @CircuitBreaker(
            requestVolumeThreshold = 2,
            failureRatio = 1.0,
            delay = 3000,
            successThreshold = 2
    )
    String getStarwarsShips();

    default String getStarwarsShipsFallback() {
        return "Fallback response: Unable to retrieve starships from the Star Wars API.";
    }

}
