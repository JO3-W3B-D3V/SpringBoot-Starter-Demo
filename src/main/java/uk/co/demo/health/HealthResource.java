package uk.co.demo.health;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is essentially where all of the application will expose some very small
 * & concise API related to the overall health of the API.
 *
 * @date 09/06/2020
 * @since 1.0.0
 * @author jo3-w3b-d3v
 */
@RestController
@RequestMapping("/health")
public class HealthResource {

	/**
     * This is the status end point.
     *
     * @since 1.0.0
     * @return String
     */
    @GetMapping(produces = TEXT_PLAIN_VALUE)
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Testing... The applications is up & running...");
    }
}
