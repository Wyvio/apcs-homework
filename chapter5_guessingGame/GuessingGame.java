
/* Jolie Zhou
 * Mr. Peterson
 * Period 2 APCS
 * 22 November 2019
 * 
 * This program plays a game in the console that lets the user guess a number.
 * I hope you enjoy the game!
 */
import java.util.*;

public class GuessingGame {
	// These set the range of numbers that can be guessed.
	public static final int MIN = 1;
	public static final int MAX = 100;

	// The main method runs multiple rounds and collects total game statistics.
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);

		// These variables are to track your game statistics
		int gamesTotal = 0;
		int guessesTotal = 0;
		int guessesBest = 1000;
		int currentGuesses = 0;

		do {
			// One round of the game is run.
			currentGuesses = runGame(console);

			// Statistics are updated.
			gamesTotal++;
			guessesTotal += currentGuesses;

			// Game with best guesses are updated.
			if (currentGuesses < guessesBest) {
				guessesBest = currentGuesses;
			}

		} while (isPlayAgain(console));

		// Prints results
		System.out.println("Your overall results:");
		System.out.println("Total games: " + gamesTotal);
		System.out.println("Total guesses: " + guessesTotal);
		System.out.println("Avg. guesses per game: " + guessesTotal / gamesTotal);
		System.out.println("Best game: " + guessesBest);

	}

	// This method runs one round of the game.
	public static int runGame(Scanner console) {
		int number = setupNumber();
		int guess = 0;
		int topGuess = 200;
		int lowGuess = 0;
		int guesses = 0;

		System.out.print("I'm thinking of a number between " + MIN + " and " + MAX + "...");

		do {
			System.out.print("\nYour guess? ");
			guess = nextGoodInput(console);
			guesses++;

			System.out.print(compareValue(lowGuess, topGuess, guess, number));

			if ((guess > number) && ((guess - number) < (topGuess - number))) {
				topGuess = guess;
			}
			if ((guess < number) && ((number - guess) < (number - lowGuess))) {
				lowGuess = guess;
			}

		} while (guess != number);

		System.out.print("You guessed it in " + guesses);
		// Uses proper grammar if the unit is 1 (singular noun).
		if (guesses == 1) {
			System.out.println(" guess!");
		} else {
			System.out.println(" guesses!");
		}

		return guesses;
	}

	// This method chooses a random number within the number range.
	public static int setupNumber() {
		Random r = new Random();
		return r.nextInt(MAX) + MIN;
	}

	// This method checks and assigns the next input if it is an integer, or skips it.
	public static int nextIntOrSkip(Scanner console) {
		// Checking for bad data type ...
		if (console.hasNextInt()) {
			return console.nextInt();
		} else {
			console.next();
			return 0;
		}
	}

	// This method repeats and returns messages until the input is a valid integer.
	public static int nextGoodInput(Scanner console) {
		int token = nextIntOrSkip(console);

		// Checking for bad integer value ...
		while (token < MIN || token > MAX) {
			System.out.println("That isn't a whole number between 1 and 100.");
			System.out.print("Your guess? ");

			token = nextIntOrSkip(console);
		}

		return token;
	}

	// This method compares the guess to the number and returns hints about what to guess next.
	public static String compareValue(int lowGuess, int topGuess, int guess, int number) {
		String response = "";
		if ((number < guess) && (topGuess <= guess)) {
			response += "I think I told you it was lower... ";
		} else if ((number > guess) && (lowGuess >= guess)) {
			response += "I think I told you it was higher... ";
		}

		if (number > guess) {
			response += "It's higher.";
		} else if (number < guess) {
			response += "It's lower.";
		}

		return response;
	}

	// This method checks if the user wants to play again.
	public static boolean isPlayAgain(Scanner console) {
		System.out.print("Play again? ");

		String token = console.next();
		char check = token.toUpperCase().charAt(0);

		return check == 'Y';

	}

}
