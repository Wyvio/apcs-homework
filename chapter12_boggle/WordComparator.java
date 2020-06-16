
/* Jolie Zhou
 * Mr. Peterson
 * APCS Period 2
 * 21 March 2020
 * 
 * Chapter 12 Boggle Project
 * 
 * WordComparator implements the Comparator interface and implements the method compare(T, T). 
 * It sorts the strings from longest length to shortest length, then alphabetical order.
 */

import java.util.Comparator;

public class WordComparator implements Comparator<String> {

	public int compare(String s1, String s2) {
		int value = s1.length() < s2.length() ? 1 : s1.length() == s2.length() ? 0 : -1;

		if (value == 0) {
			value = s1.compareTo(s2);
		}

		return value;
	}

}
