package keehinmccann.assignment5.adoptme.controller.inputvalidation;

/**
 * Class for input validation
 */
public class ValidateUserInput {
	/**
	 * Validates that the string is not null and not empty
	 * @param input input string
	 * @return false if the string is null or empty, true otherwise
	 */
	public static boolean validateInputNotNull(String input) {
		if (input == null || input.equals("")) {
			return false;
		}
		return true;
	}
	/**
	 * Validates that the string is a valid integer
	 * @param input input string
	 * @return false if the string cannot be parsed to an integer, true otherwise
	 */
	public static boolean validateInputInteger(String input) {
		try {
			Integer.parseInt(input);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
