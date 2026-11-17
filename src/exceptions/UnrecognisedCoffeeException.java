/**
 * Contains the custom exceptions
 */
package exceptions;

/**
 * This class contains a custom exception for when the user
 * inputs something that isn't a coffee type.
 * @author giannaestrada
 */
public class UnrecognisedCoffeeException extends Exception {

	public UnrecognisedCoffeeException(String message) {
		super(message);
	}
}
