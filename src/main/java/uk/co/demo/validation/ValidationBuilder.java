package uk.co.demo.validation;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.lang.Integer.compare;
import static java.util.Optional.of;
import static java.util.Optional.ofNullable;

import java.util.Collection;
import java.util.Optional;
import java.util.regex.Pattern;

/**
 * The purpose of this class is to implement a clean way to 
 * implement validation, essentially allowing validation to
 * be more expressive.
 * 
 * @author jo3-w3b-d3v
 * @since 09/08/2020
 * @version 1.0.0
 */
public abstract class ValidationBuilder {
	
	protected Pattern regex;
	protected String message;
	protected String argument = null;
	protected Integer length = null;
	protected RuntimeException exception = null;
	
	/**
	 * The purpose of this method is to compare two numeric values.
	 * 
	 * @param x
	 * @param y
	 * @throws RuntimeException
	 * @return ValidationBuilder
	 */
	public ValidationBuilder whenLessThan(int x, int y) throws RuntimeException {
		return of(x)
			.map(z -> Integer.valueOf(compare(z, y)))
			.filter(z -> FALSE.equals(z.equals(-1)))
			.map(z -> this)
			.orElseThrow(() -> ofNullable(exception).orElseGet(() -> new IllegalArgumentException(message)));
	}
	
	/**
	 * The purpose of this method is to compare a numeric value
	 * against the length of the argument property.
	 * 
	 * @param x
	 * @throws RuntimeException
	 * @return ValidationBuilder
	 */
	public ValidationBuilder whenLessThan(int x) throws RuntimeException {
		return whenLessThan(ofNullable(length).orElse(argument.trim().length()), x);
	}
	
	/**
	 * The purpose of this method is to compare two numeric values.
	 * 
	 * @param x
	 * @param y
	 * @throws RuntimeException
	 * @return ValidationBuilder
	 */
	public ValidationBuilder whenGreaterThan(int x, int y) throws RuntimeException {
		return of(x)
			.map(z -> Integer.valueOf(compare(z, y)))
			.filter(z -> FALSE.equals(z.equals(1)))
			.map(z -> this)
			.orElseThrow(() -> ofNullable(exception).orElseGet(() -> new IllegalArgumentException(message)));
	}
	
	/**
	 * The purpose of this method is to compare a numeric value
	 * against the length of the argument property.
	 * 
	 * @param x
	 * @throws RuntimeException
	 * @return ValidationBuilder
	 */
	public ValidationBuilder whenGreaterThan(int x) throws RuntimeException {
		return whenGreaterThan(ofNullable(length).orElseGet(() -> argument.trim().length()), x);
	}
	
	/**
	 * The purpose of this method is to ensure that the provided 
	 * argument is not empty.
	 * 
	 * @param argument
	 * @throws RuntimeException
	 * @return ValidationBuilder
	 */
	public ValidationBuilder whenEmpty(String argument) throws RuntimeException {
		return of(argument.trim().isEmpty())
			.filter(FALSE::equals)
			.map(z -> this)
			.orElseThrow(() -> ofNullable(exception).orElseGet(() -> new IllegalArgumentException(message)));
	}
	
	/**
	 * The purpose of this method is to ensure that the provided 
	 * list is not empty.
	 * 
	 * @param collection 
	 * @throws RuntimeException 
	 * @return ValidationBuilder
	 */
	public ValidationBuilder whenEmpty(Collection<?> collection) throws RuntimeException {
		return ofNullable(collection.isEmpty())
			.filter(FALSE::equals)
			.map(z -> this)
			.orElseThrow(() -> ofNullable(exception).orElseGet(() -> new IllegalArgumentException(message)));
	}
	
	/**
	 * The purpose of this method is to ensure that the provided 
	 * list is not empty.
	 * 
	 * @param optional 
	 * @throws RuntimeException 
	 * @return ValidationBuilder
	 */
	public ValidationBuilder whenEmpty(Optional<?> optional) throws RuntimeException {
		return ofNullable(optional.isEmpty())
			.filter(FALSE::equals)
			.map(z -> this)
			.orElseThrow(() -> ofNullable(exception).orElseGet(() -> new IllegalArgumentException(message)));
	}
	
	/**
	 * The purpose of this method is to ensure that the provided 
	 * argument property is not empty.
	 * 
	 * @throws RuntimeException
	 * @return ValidationBuilder
	 */
	public ValidationBuilder whenEmpty() throws RuntimeException {
		return whenEmpty(argument);
	}
	
	/**
	 * The purpose of this method is to ensure that the provided 
	 * argument is not null.
	 * 
	 * @param argument
	 * @throws RuntimeException
	 * @return ValidationBuilder
	 */
	public ValidationBuilder whenNull(Object argument) throws RuntimeException {
		return ofNullable(argument)
			.map(z -> this)
			.orElseThrow(() -> ofNullable(exception).orElseGet(() -> new IllegalArgumentException(message)));
	}
	
	/**
	 * The purpose of this method is to ensure that the provided 
	 * argument property is not null.
	 * 
	 * @throws RuntimeException
	 * @return ValidationBuilder
	 */
	public ValidationBuilder whenNull() throws RuntimeException {
		return whenNull(argument);
	}
	
	/**
	 * The purpose of this method is to check to see if some 
	 * string contains some substring.
	 * 
	 * @param argument 
	 * @param substring
	 * @throws RuntimeException
	 * @return ValidationBuilder
	 */
	public ValidationBuilder whenNoSubstringExists(String argument, String substring) throws RuntimeException {
		return of(argument.toLowerCase().contains(String.valueOf(substring).toLowerCase()))
			.filter(TRUE::equals)
			.map(z -> this)
			.orElseThrow(() -> ofNullable(exception).orElseGet(() -> new IllegalArgumentException(message)));
	}
	
	/**
	 * The purpose of this method is to check to see if the provided 
	 * argument property contains some substring.
	 * 
	 * @param substring
	 * @throws RuntimeException
	 * @return ValidationBuilder
	 */
	public ValidationBuilder whenNoSubstringExists(String substring) throws RuntimeException {
		return whenNoSubstringExists(argument, substring);
	}
	
	/**
	 * The purpose of this method is to ensure that the provided
	 * argument matches the given regex.
	 * 
	 * @param argument
	 * @throws RuntimeException
	 * @return ValidationBuilder
	 */
	public ValidationBuilder whenNoRegexMatch(String argument) throws RuntimeException {
		return of(regex.matcher(argument).find())
			.filter(TRUE::equals)
			.map(z -> this)
			.orElseThrow(() -> ofNullable(exception).orElseGet(() -> new IllegalArgumentException(message)));
	}
	
	/**
	 * The purpose of this method is to ensure that the provided
	 * argument property matches the given regex.
	 * 
	 * @throws RuntimeException
	 * @return ValidationBuilder
	 */
	public ValidationBuilder whenNoRegexMatch() throws RuntimeException {
		return whenNoRegexMatch(argument);
	}
	
	/**
	 * This is nothing more than a setter method in the style
	 * of a builder pattern. This method will set the regular 
	 * expression.
	 * 
	 * @param regex
	 * @return ValidationBuilder
	 */
	public ValidationBuilder regex(Pattern regex) {
		this.regex = regex;
		return this;
	}
	
	/**
	 * This is nothing more than a setter method in the style 
	 * of a builder pattern. This method will set the message that 
	 * will be used when throwing an exception.
	 * 
	 * @param message
	 * @return ValidationBuilder
	 */
	public ValidationBuilder message(String message) {
		this.message = message;
		return this;
	}
	
	/**
	 * This is nothing more than a setter method in the style 
	 * of a builder pattern. This method will set the argument 
	 * property.
	 * 
	 * @param argument
	 * @return ValidationBuilder
	 */
	public ValidationBuilder argument(String argument) {
		this.argument = argument;
		return this;
	}
	
	/**
	 * This is nothing more than a setter method in the style 
	 * of a builder pattern. This method will set the length 
	 * property.
	 * 
	 * @param length
	 * @return ValidationBuilder
	 */
	public ValidationBuilder length(Integer length) {
		this.length = length;
		return this;
	}
	
	/**
	 * This is nothing more than a setter method in the style 
	 * of a builder pattern. This method will set the exception 
	 * property.
	 * 
	 * @param exception
	 * @return ValidationBuilder
	 */
	public ValidationBuilder exception(RuntimeException exception) {
		this.exception = exception;
		return this;
	}
}
