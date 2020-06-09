package uk.co.demo.resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import lombok.SneakyThrows;

/**
 * This is the unit tests that will be used for testing the health 
 * resource class.
 *
 * @date 09/06/2020
 * @since 1.0.0
 * @author jo3-w3b-d3v
 */
@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("When HealthResource (integration tests)")
public class HealthResourceIT {
	
	@Autowired
    private MockMvc mvc;
	
	/**
	 * This unit test will just test to make sure that the status endpoint 
	 * doesn't fail. 
	 * 
	 * @since 1.0.0
	 */
	@Test
	@SneakyThrows
	@DisplayName("status succeeds")
	public void testStatus() {
		mvc.perform(get("/health"))
			.andDo(print())
			.andExpect(status().isOk());
	}
}
