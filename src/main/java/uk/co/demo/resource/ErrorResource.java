package uk.co.demo.resource;

import static org.springframework.http.MediaType.TEXT_PLAIN;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.jbosslog.JBossLog;
import uk.co.demo.exception.InvalidParamProvided;
import uk.co.demo.exception.ResourceNotFoundException;

/**
 * This is essentially where all of the exceptions will be handled, due to how
 * minimal this class is, there is currently no need for a service layer.
 *
 * @date 09/06/2020
 * @since 1.0.0
 * @author jo3-w3b-d3v
 */
@JBossLog
@ControllerAdvice
public class ErrorResource {

    /**
     * This method will be used to catch all exceptions that are not being caught at
     * the application level.
     *
     * @since 1.0.0
     * @param throwable
     * @return ResponseEntity
     */
    @ExceptionHandler({ Throwable.class, Exception.class })
    public ResponseEntity<String> error(Throwable throwable) {
        log.error("Internal server error", throwable);

        return ResponseEntity.status(500)
                .contentType(TEXT_PLAIN)
                .body("Internal server error.");
    }

    /**
     * This method will be used to handle requests that will result in a 400.
     * 
     * @since 1.0.0
     * @param exception
     * @return ResponseEntity
     */
    @ExceptionHandler({ InvalidParamProvided.class })
    public ResponseEntity<String> invalidParams(Exception exception) {
    	log.info("Invalid parameters provided", exception);
    	
    	return ResponseEntity.status(400)
    			.contentType(TEXT_PLAIN)
    			.body(exception.getMessage() + ".");
    }
    
    /**
     * This method will be used to handle requests that will result in a 404.
     *
     * @since 1.0.0
     * @param exception
     * @return ResponseEntity
     */
    @ExceptionHandler({ NoHandlerFoundException.class, ResourceNotFoundException.class })
    public ResponseEntity<String> notFound(Exception exception) {
        log.error("Handling no resource found", exception);

        return ResponseEntity.status(404)
                .contentType(TEXT_PLAIN)
                .body("No resource found.");
    }
}
