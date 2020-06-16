
/* Jolie Zhou
 * Mr. Peterson
 * APCS Period 2
 * 21 March 2020
 * 
 * Chapter 12 Boggle Project
 * 
 * This program automatically creates and solves a 4 by 4 randomly-generated Boggle board.
 */

import java.util.ArrayList;

public class Program {

	// The main method creates the board and formats the results.
	public static void main(String args[]) {
		final int minLength = 3;
		final int maxLength = 8;

		WordList wordList = new WordList("WordList.txt", minLength, maxLength);
		Board board = new Board(wordList, 4);
		System.out.print(board);
		ArrayList<String> allWords = board.find();

		// Formatting of results
		System.out.println("\nFound " + allWords.size() + " word(s)\n");

		for (int i = maxLength; i >= minLength; i--) {
			ArrayList<String> words = findByLength(allWords, i);

			if (words.size() > 0) {
				System.out.println(i + " letter words");

				for (String s : words) {
					System.out.println(s);
				}

				System.out.println();
			}
		}
	}

	// Finds all the words of given length and returns them in an ArrayList.
	public static ArrayList<String> findByLength(ArrayList<String> allWords, int length) {
		ArrayList<String> words = new ArrayList<String>();

		for (int i = 0; i < allWords.size(); i++) {
			if (allWords.get(i).length() == length) {
				words.add(allWords.get(i));
			}

			if (allWords.get(i).length() < length) {
				i = allWords.size();
			}
		}

		return words;
	}
}
