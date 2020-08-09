package uk.co.demo.product;

import static java.util.Optional.ofNullable;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import uk.co.demo.exception.InvalidParamProvided;
import uk.co.demo.exception.NoProductFoundException;
import uk.co.demo.validation.ValidationBuilder;
import uk.co.demo.validation.Validator;

/**
 * The purpose of this class is to merely implement some form of validation
 * some validation around the product params.
 * 
 * @author jo3-w3b-d3v
 * @since 09/08/2020
 * @version 1.0.0
 */
@Component
public class ProductValidation extends ValidationBuilder implements Validator<Integer> {
		
	/**
	 * This method is used to validate the page index argument.
	 * 
	 * @param password
	 * @throws InvalidParamProvided
	 */
	@Override
	public void validate(Integer pageIndex) throws InvalidParamProvided {		
		// First check that the page index is not null.
		exception(new InvalidParamProvided("The page number must be provided"))
			.whenNull(pageIndex);
		
		// Then check that the page index is greater than 0.
		exception(new InvalidParamProvided("The page number must be greater than 0"))
			.whenLessThan(pageIndex, 0);
	}
	
	/**
	 * This method is used to validate that the provided list 
	 * isn't empty.
	 * 
	 * @param list 
	 * @param printableIndex
	 * @throws InvalidParamProvided
	 */
	public void validateIsNotEmpty(List<Product> list, Integer printableIndex) throws InvalidParamProvided {
		String message = "The page number provided is too large, there are no products on the page ";
		
		// Just check that the list isn't empty.
		exception(new InvalidParamProvided(message + printableIndex))
			.whenEmpty(ofNullable(list).orElseGet(() -> Collections.emptyList()));
	}
	
	/**
	 * This method is used to validate that the provided optional
	 * object isn't empty.
	 * 
	 * @param optional 
	 * @throws InvalidParamProvided
	 */
	public void validateIsNotEmpty(Optional<Product> optional, Integer id) throws NoProductFoundException {
		// Just check that the optional object isn't empty.
		exception(new NoProductFoundException(id))
			.whenEmpty(Optional.ofNullable(optional).orElseGet(() -> Optional.empty()));
	}
}
