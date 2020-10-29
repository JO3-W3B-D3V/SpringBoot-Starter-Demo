package uk.co.demo.exception;

/**
 * The purpose of this exception is to specify what resource was not found.
 * 
 * @date 09/06/2020
 * @since 1.0.0
 * @author jo3-w3b-d3v
 */
@SuppressWarnings("serial")
public abstract class ResourceNotFoundException extends RuntimeException {
	
	/**
	 * This is just a general no-arg constructor.
	 */
	protected ResourceNotFoundException() {
		super("Resource not found");
	}
	
	/**
	 * This is just a general constructor.
	 *
	 * @param message
	 */
	protected ResourceNotFoundException(String message) {
		super(message);
	}
}
