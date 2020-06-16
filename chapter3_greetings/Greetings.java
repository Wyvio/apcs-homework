//	Jolie Zhou
//	Mr. Peterson
//	Period 2 APCS
//	9 October 2019
// This program prints out a greeting after receiving input from the user.

// This import will import both the Scanner and Calendar classes.
import java.util.*;

public class Greetings {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);

		dataAndGreet(console);

	}

	public static void dataAndGreet(Scanner console) {
		// This method gets all the data and then uses it to greet the user.

		System.out.println("Please enter your first name: ");
		String fName = console.next();

		System.out.println("Please enter your last name: ");
		String lName = console.next();

		System.out.println("Please enter your year of birth: ");
		int year = console.nextInt();

		// All the data is inputted in the method to greet you!
		greet(fName, lName, year);
	}

	public static void greet(String first, String last, int year) {
		// This method prints out the greeting.

		String name = properCase(first).charAt(0) + ". " + properCase(last);

		int currentYear = (Calendar.getInstance().get(Calendar.YEAR));
		int age = currentYear - year;

		// The greeting is formatted as "Greetings, <>! You are about <> years old."
		System.out.println("Greetings, " + name + "! You are about " + age + " years old.");

	}

	public static String properCase(String text) {
		// This method changes the inputted String such that the first letter is
		// uppercase and the rest is lowercase.
		return text.toUpperCase().charAt(0) + text.toLowerCase().substring(1);
	}

}
