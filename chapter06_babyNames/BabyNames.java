/* Jolie Zhou
 * Mr. Peterson
 * APCS Period 2
 * 27 November 2019
 * 
 * This code returns data about baby names from every decade from 1900 to 2000.
 * It receives data from name.txt and outputs your own .txt file about a baby name!
 */

import java.io.*;
import java.util.*;

public class BabyNames {

	// Main method
	public static void main(String[] args) throws FileNotFoundException {
		// Scanners setup
		Scanner console = new Scanner(System.in);
		Scanner file = new Scanner(new File("names.txt"));

		// Runs header text in console
		runSetup();

		// Repeats name data until not "y"
		do {
			runName(console, file);
			
			// Resets scanners so they start at the beginning again.
			console = new Scanner(System.in);
			file = new Scanner(new File("names.txt"));
		} while (isAgain(console));

	}

	// Prints header: Popularity of a baby name since year 1900
	public static void runSetup() {
		System.out.println("** Popularity of a baby name since year 1900 **");
		System.out.println();
	}

	// Asks for name and retrieves data from name.txt, and outputs file to computer
	public static void runName(Scanner console, Scanner file) throws FileNotFoundException {
		System.out.print("name? ");
		String name = console.next();
		name = name.toUpperCase().charAt(0) + name.toLowerCase().substring(1);

		boolean isFound = false;

		//Loops through each line and checks its first token
		String line = "";
		do {
			line = file.nextLine();
			Scanner lineScanner = new Scanner(line);
			if (lineScanner.hasNext()) {
				isFound = lineScanner.next().equalsIgnoreCase(name);
			}
		} while (file.hasNextLine() && !isFound);

		//Prints out information of line if found
		if (isFound) {
			PrintStream nameFile = new PrintStream(new File(name + ".txt"));
			nameFile.println("name? " + name + "\n");
			
			Scanner lineScan = new Scanner(line);
			lineScan.next();
			for (int i = 0; i <= 10; i++) {
				printBoth(nameFile, 1900 + 10 * i + ": " + lineScan.next());
			}
		} else {
			System.out.println("name not found.");
		}

	}

	// Checks if user wants to retrieve data for another name
	public static boolean isAgain(Scanner console) {
		System.out.println("Would you like to search another name?");
		return console.next().equals("y");
	}

	// Prints text to both the file and the console
	public static void printBoth(PrintStream nameFile, String text) {
		nameFile.println(text);
		System.out.println(text);
	}

}
