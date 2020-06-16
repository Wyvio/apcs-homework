
/*	Jolie Zhou
 * 	Mr. Peterson
 * 	Period 2 APCS
 * 	29 October 2019
 * 
 * 	This program compares two peoples' birthdays to today's date, printing out the day of the 
 * 	year and the difference of days between the various dates inputed. At the end, it prints a 
 * 	fun fact about a day in the year.
 */

import java.util.*;

public class Birthdays {

	// This is the main method. It calls the prompts.
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);

		System.out.print("Please enter today's date (month day): ");
		int todayMonth = console.nextInt();
		int todayDay = console.nextInt();
		int todayNum = toDays(todayMonth, todayDay);

		String todayDate = formatDate(todayMonth, todayDay, 2019);

		System.out.print("Today is " + todayDate + ", day #" + todayNum + " of the year.");

		System.out.println("\nPerson #" + compareTwoSoon(console, todayNum) + "'s birthday is sooner.");

		System.out.println("Did you know? #LifeInsuranceDay - May 2nd is National Life Insurance Day.");
	}

	// This method compares the two inputed birthdays and calls the prompts.
	public static int compareTwoSoon(Scanner console, int todayNum) {
		if (inputBirthday(console, 1, todayNum) < inputBirthday(console, 2, todayNum)) {
			return 1;
		} else {
			return 2;
		}
	}

	// This method asks the prompts for the birthday and returns the days of the
	// year.
	public static int inputBirthday(Scanner console, int iteration, int todayNum) {
		System.out.print("\nPlease enter person #" + iteration + "'s birthday (month day): ");
		int month = console.nextInt();
		int day = console.nextInt();
		int num = toDays(month, day);

		System.out.print(formatDate(month, day, 2019) + " falls on day #" + num + " of 365. Your next birthday is in "
				+ daysToNext(num, todayNum) + " day(s).");

		return num;
	}

	// This method returns the number of days between two dates (given their days of
	// the year) and adjusts accordingly to leap years.
	public static int daysToNext(int num, int todayNum) {
		if (num < todayNum) {
			return 366 - (int) Math.abs((double) todayNum - (double) num);
		} else {
			return num - todayNum;
		}
	}

	// This method converts a date (month, day) to days of the year.
	public static int toDays(int month, int day) {
		int sum = 0;
		for (int i = 0; i < month; i++) {
			sum += daysInMonth(i);
		}
		sum += day;
		return sum;
	}

	// This method returns the number of days in a month given the month.
	public static int daysInMonth(int month) {
		if (month > 0 && month <= 7) {
			if (month == 2) {
				return 28;
			} else if (month % 2 == 0) {
				return 30;
			} else {
				return 31;
			}
		} else if (month >= 8 && month % 2 == 0) {
			return 31;
		} else if (month >= 8 && month % 2 == 1) {
			return 30;
		} else {
			return 0;
		}
	}

	// This method formats the date (month/day/year) and returns the String.
	public static String formatDate(int month, int day, int year) {
		return month + "/" + day + "/" + year;
	}
}
