/**
 * Yovel Glisko
 * Dec 4, 2020
**/
public class DivisionByZeroException extends Exception{
	public DivisionByZeroException() {
		super("Attempted to divide by zero. This is not possible.");
	}
}
