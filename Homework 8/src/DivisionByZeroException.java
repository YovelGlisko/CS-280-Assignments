/**
 * Yovel Glisko
 * Dec 4, 2020
**/
public class DivisionByZeroException extends Exception{
	public DivisionByZeroException() {
		// this is a barebones Exception class which simply has an error associated with it.
		super("Attempted to divide by zero. This is not possible.");
	}
}
