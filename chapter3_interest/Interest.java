
/* Jolie Zhou
 * Mr. Peterson
 * APCS Period 2
 * 14 October 2019
 * 
 * This program prints out the financial records of someone's money depending on
 * the values they input into the program.
 */

import java.util.*;

public class Interest {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);

		// These variables receive the inputted value from the user.
		double balance = inputDouble(console, "Enter your initial investment:");
		double deposit = inputDouble(console, "Enter your annual deposit:");
		double years = inputDouble(console, "Enter number of Years:");
		double rate = inputDouble(console, "Enter interest rate:") / 100;

		// The header is printed (it is wider than the sample because of the tab
		// length).
		printHeader(balance);

		// This loops through the rows until the number of years are reached.
		double increase;
		for (int y = 1; y <= years; y++) {
			// The increase is updated.
			increase = rate * balance + deposit;

			// The row is printed with the increased balance without changing the value.
			printRow(y, rate * balance, deposit, balance + truncate(increase));

			// The balance is updated.
			balance += truncate(increase);
			// NOTE TO SELF: fixed! to mimic the solution's truncation bug, simply truncate
			// the balance.
			balance = truncate(balance);

		}
	}

	public static double inputDouble(Scanner scanner, String prompt) {
		// This is the method that passes in the user's input.
		System.out.println(prompt);
		return scanner.nextDouble();
	}

	public static double truncate(double x) {
		// This method truncates the double to two decimal points.
		return (int) (x * 100.0) / 100.0;
	}

	public static void printRow(int y, double i, double d, double b) {
		// This method prints out the row of the financial log.
		System.out.println(y + "\t" + truncate(i) + "\t" + truncate(d) + "\t" + truncate(b));

	}

	public static void printHeader(double b) {
		// This method prints out the header with corrected spacing.
		System.out.println("Year\tInt.\tDeposit\tBalance");
		System.out.println("start\t\t\t" + truncate(b));
	}
}
