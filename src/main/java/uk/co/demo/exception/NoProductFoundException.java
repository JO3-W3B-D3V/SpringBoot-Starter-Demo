package uk.co.demo.exception;

/**
 * The purpose of this exception is to specify what resource was not found.
 * 
 * @date 09/06/2020
 * @since 1.0.0
 * @author jo3-w3b-d3v
 */
@SuppressWarnings("serial")
public class NoProductFoundException extends ResourceNotFoundException {
	
	/**
	 * This is just a general constructor.
	 *
	 * @param id
	 */
	public NoProductFoundException(Integer id) {
		super("Product not found with the id " + id);
	}
}
