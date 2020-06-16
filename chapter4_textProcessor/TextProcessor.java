/*	Jolie Zhou
 * 	Mr. Peterson
 * 	P2 APCS
 * 	23 October 2019
 * 
 * 	This class implements some static methods for char primitives and String objects.
 */
public class TextProcessor {

	public static void main(String[] args) {

		// Below are the test cases for the method isLowerCase(char)
		System.out.println(isLowerCase('a'));
		System.out.println(isLowerCase('W'));
		System.out.println(isLowerCase('.'));

		// Below are the test cases for the method toUpperCase(char)
		System.out.println(toUpperCase('a'));
		System.out.println(toUpperCase('W'));
		System.out.println(toUpperCase('?'));

		// Below are the test cases for the method toUpperCase(String)
		System.out.println(toUpperCase("Interlake HS"));
		System.out.println(toUpperCase("tExT pRoCeSsOr"));
		System.out.println(toUpperCase("? ^-^ ?"));

		// Below are the test cases for the method compareToIgnoreCase(String, String)
		System.out.println(compareToIgnoreCase("hello", "HELLO"));
		System.out.println(compareToIgnoreCase("hello", "flag"));

		// To match compareTo(String), compareToIgnoreCase(String, String) will print
		// the difference of the Strings, first String - second String
		System.out.println(compareToIgnoreCase("InTeRlAkE", "interlake hs"));

		// Here is a reference. It prints the difference in length.
		System.out.println("interlake".compareTo("interlake hs"));

	}

	public static boolean isLowerCase(char c) {
		// This method returns true if the specified character is a lowercase letter
		// Otherwise, it returns false.
		boolean result = false;
		if (c >= 'a' && c <= 'z') {
			result = true;
		}

		return result;
	}

	public static char toUpperCase(char c) {
		// This method returns an uppercase version of the character (if it is
		// lowercase).
		// Otherwise, it returns the original character.
		char result = c;
		if (isLowerCase(c)) {
			// The ' ' character is equivalent to the difference between upper and lower
			// case
			// letters.
			result -= ' ';
		}

		return result;
	}

	public static String toUpperCase(String s) {
		// This method returns an uppercase version of the specified string.
		// All lowercase letters are uppercased. All other characters are unchanged.
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			result += toUpperCase(s.charAt(i));
		}

		return result;
	}

	public static int compareToIgnoreCase(String s, String t) {
		// This method compares the specified strings, ignoring the case of individual
		// characters.
		// It returns a negative value if the first string is less than the second, and
		// positive value if the first value is greater than the second.
		// Otherwise, it returns zero.

		s = toUpperCase(s);
		t = toUpperCase(t);

		int result = 0;

		// This conditional checks the lengths of the strings to avoid the
		// IndexOutOfBoundsException.
		// It then sets a variable to the longest length both Strings can check to.
		int loop = s.length();
		if (s.length() > t.length()) {
			loop = t.length();
		}

		// This loop compares each individual character.
		// The loop stops when there is a character difference.
		for (int i = 0; i < loop; i++) {
			result = s.charAt(i) - t.charAt(i);
			if (result != 0)
				i = loop;
		}

		// This conditional runs when the loop finds all the characters of shared length
		// are the same.
		// It returns the difference in length compared from the first String to the
		// second.
		// If the Strings were equal anyway, the result would still be 0 because they
		// would have the same length anyway.
		if (result == 0) {
			result = s.length() - t.length();
		}

		return result;

	}

}
