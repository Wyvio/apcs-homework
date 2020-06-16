
/* Jolie Zhou
 * Mr. Peterson
 * APCS Period 2
 * 10 December 2019
 * 
 * This program adds numbers up to 25 digits with accuracy from a file. 
 * The numbers on each line are added, so numbers from one line make one equation.
 * It outputs the results in the console with the equations solved.
 */

import java.io.*;
import java.util.*;

public class Sum {

	public static final int DIGIT_LENGTH = 25;

	// Repeats through each line of the file
	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("sum.txt"));

		while (file.hasNextLine()) {
			String[] numbers = getNumbers(file.nextLine());
			formatZeroes(numbers, true);
			numbers[numbers.length - 1] = getSum(numbers);
			formatZeroes(numbers, false);
			formatOutput(numbers);
		}

	}

	// Returns an array of all the numbers in the line + 1 (last one is empty for the sum)
	public static String[] getNumbers(String line) {
		// Finds how large the array needs to be
		Scanner count = new Scanner(line);
		Scanner tokens = new Scanner(line);
		int arraySize = 0;
		while (count.hasNext()) {
			arraySize++;
			count.next();
		}

		// Creates array of numbers to sum (last one is empty: sum)
		String[] numbers = new String[arraySize + 1];

		// Puts numbers in array
		for (int i = 0; tokens.hasNext(); i++) {
			numbers[i] = tokens.next();
		}

		// Set last number (sum) to empty
		numbers[numbers.length - 1] = "";

		// Return array with numbers
		return numbers;
	}

	// Adds/removes zeroes from all numbers in the array until each number's length is DIGIT_LENGTH
	public static void formatZeroes(String[] numbers, boolean isAdd) {
		String num = "";
		int zeroes = 0;
		boolean isAllZero = true;

		int startPlace = 0;

		// Checks if isAdd; if true, adds zeroes, else, remove zeroes
		if (isAdd) {
			// Adds zeroes to all numbers except last one
			for (int i = 0; i < numbers.length - 1; i++) {
				num = numbers[i];
				numbers[i] = "";
				zeroes = DIGIT_LENGTH - num.length();
				for (int z = 0; z < zeroes; z++) {
					numbers[i] += "0";
				}
				numbers[i] += num;
			}
		} else {
			// Loops through all numbers
			for (int i = 0; i < numbers.length; i++) {
				startPlace = 0;

				// Loops through all digits of one number
				for (int p = 0; p < numbers[i].length(); p++) {

					// Checks if still 0
					if (numbers[i].charAt(p) != '0') {
						isAllZero = false;

						// Assigns variable to place where no longer 0
						startPlace = p;
						p = numbers[i].length();
					}
				}

				// Replaces number
				numbers[i] = numbers[i].substring(startPlace);

				// If all character is a '0', change to '0'
				if (isAllZero) {
					numbers[i] = "0";
				}
			}
		}
	}

	// Sums all the numbers in the array and sets last number to sum
	public static String getSum(String[] numbers) {
		int[] sumDigits = new int[DIGIT_LENGTH];
		int digitsSum = 0;
		String sum = "";

		// Loop through all digits
		for (int d = DIGIT_LENGTH - 1; d >= 0; d--) {

			// Get sum of digits in one place value (i is the number added from)
			for (int i = 0; i < numbers.length - 1; i++) {
				digitsSum += Character.getNumericValue(numbers[i].charAt(d));
			}

			// Carries over values and assigns digits (i^10 is the place value)
			for (int i = 0; digitsSum > 0; i++) {
				sumDigits[d - i] += (digitsSum % (int) Math.pow(10, i + 1)) / (int) Math.pow(10, i);

				for (int x = 1; sumDigits[d - i] >= 10; x++) {
					sumDigits[d - i - x] += (sumDigits[d - i] % (int) Math.pow(10, i + 2)) / (int) Math.pow(10, i + 1);
					sumDigits[d - i] = (sumDigits[d - i] % (int) Math.pow(10, i + 1)) / (int) Math.pow(10, i);
				}

				digitsSum -= digitsSum % (int) Math.pow(10, i + 1);
			}

			// Resets sum of digits and moves onto next digit
			digitsSum = 0;
		}

		// Processes array of digits to one string
		for (int i = 0; i < sumDigits.length; i++) {
			sum += sumDigits[i];
		}

		return sum;
	}

	// Outputs the equation given array
	public static void formatOutput(String[] numbers) {
		if (numbers.length > 1) {
			for (int i = 0; i < numbers.length - 2; i++) {
				System.out.print(numbers[i] + " + ");
			}
			System.out.print(numbers[numbers.length - 2]);
		} else {
			System.out.print(numbers[0]);
		}
		System.out.print(" = ");
		System.out.print(numbers[numbers.length - 1]);
		System.out.println();
	}

}
