package israelgda.configs;

import israelgda.clients.StarwarsService;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Readiness
public class ReadinessCheck implements HealthCheck {

    @RestClient
    StarwarsService starwarsService;

    @Override
    public HealthCheckResponse call() {
        if(starwarsService.getStarwarsShips().contains(StarwarsService.ERROR_MSG)) {
            return HealthCheckResponse.down("Starwars Service is currently unavailable.");
        } else {
            return HealthCheckResponse.up("Starwars Service is available.");
        }
    }
}
