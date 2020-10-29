package uk.co.demo.exception;


/**
 * The purpose of this exception is to specify what param that was provided 
 * to the API is invalid.
 * 
 * @date 09/06/2020
 * @since 1.0.0
 * @author jo3-w3b-d3v
 */
@SuppressWarnings("serial")
public class InvalidParamProvided extends RuntimeException {
	
	/**
	 * This is just a general constructor.
	 *
	 * @param message
	 */
	public InvalidParamProvided(String message) {
		super(message);
	}
}
