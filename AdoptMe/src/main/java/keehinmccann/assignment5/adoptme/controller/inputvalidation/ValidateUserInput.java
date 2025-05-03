package keehinmccann.assignment5.adoptme.controller.inputvalidation;

public class ValidateUserInput {
	public static boolean validateInputNotNull(String input) {
		if (input == null || input.equals("")) {
			return false;
		}
		return true;
	}
	public static boolean validateInputInteger(String input) {
		try {
			Integer.parseInt(input);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
