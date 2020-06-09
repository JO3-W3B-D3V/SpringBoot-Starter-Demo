package uk.co.demo.exception;

@SuppressWarnings("serial")
public abstract class ResourceNotFoundException extends RuntimeException {
	protected ResourceNotFoundException() {
		super("Resource not found");
	}
	
	protected ResourceNotFoundException(String message) {
		super(message);
	}
}
