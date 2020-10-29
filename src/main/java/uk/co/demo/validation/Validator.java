package uk.co.demo.validation;

/**
 * The purpose of this interface is to set the minimal requirements for the 
 * classes that will implement some form of guard clause.
 * 
 * @author jo3-w3b-d3v
 * @since 09/08/2020
 * @version 1.0.0
 */
public interface Validator<T> {

	/**
	 * This method is used to validate a given argument, if the argument is invalid 
	 * then a runtime exception will be thrown.
	 * 
	 * @param argument 
	 * @throws RuntimeException
	 */
	public void validate(T argument) throws RuntimeException;
	
	/**
	 * This can be used by the consuming code to dictate if a given output is invalid 
	 * or not. 
	 * 
	 * @param argument
	 * @return boolean
	 */
	public default boolean isValid(T argument) {
		try {
			this.validate(argument);
			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}
}

