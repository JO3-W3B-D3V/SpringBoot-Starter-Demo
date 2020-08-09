package uk.co.demo.health;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * This is the unit tests that will be used for testing the health 
 * resource class.
 *
 * @date 09/06/2020
 * @since 1.0.0
 * @author jo3-w3b-d3v
 */
@DisplayName("When HealthResourceV1 (unit tests)")
public class HealthResourceV1Test {
	
	private HealthResourceV1 resource;
	
	/**
	 * This is just your typical setup method.
	 * 
	 * @since 1.0.0
	 */
	@BeforeEach
	private void setup() {
		resource = new HealthResourceV1();
	}
	
	/**
	 * This unit test will just test to make sure that the status end point 
	 * doesn't fail. 
	 * 
	 * @since 1.0.0
	 */
	@Test
	@DisplayName("status succeeds")
	public void testStatus() {
		assertTrue(resource.health().getStatusCode().is2xxSuccessful());
	}
}
