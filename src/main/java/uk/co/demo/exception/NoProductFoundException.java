package uk.co.demo.exception;

@SuppressWarnings("serial")
public class NoProductFoundException extends ResourceNotFoundException {
	
	public NoProductFoundException(Integer id) {
		super("Product not found with the id " + id);
	}
}
