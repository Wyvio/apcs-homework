
/* Jolie Zhou
 * Mr. Peterson
 * APCS Period 2
 * 21 March 2020
 * 
 * Chapter 12 Boggle Project
 *  
 * The Board class creates a Boggle board.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Board {

	String[][] board;
	WordList wordList;

	// Constructor
	public Board(WordList wordList, int boardSize) {
		Random random = new Random();

		// Instantiates board as 2D array of Strings
		board = new String[boardSize][boardSize];

		// Instantiates WordList of words
		this.wordList = wordList;

		// Populates array with random letters from random words in the list
		for (int r = 0; r < boardSize; r++) {
			for (int c = 0; c < boardSize; c++) {
				String randomWord = wordList.get(random.nextInt(wordList.size()));
				board[r][c] = randomWord.charAt(random.nextInt(randomWord.length())) + "";
			}
		}
	}

	// Returns sorted ArrayList of all the valid words found in the board
	public ArrayList<String> find() {
		ArrayList<String> validWords = new ArrayList<String>();

		find(0, 0, new ArrayList<String>(), validWords);

		Collections.sort(validWords, new WordComparator());
		return validWords;
	}

	// HELPER METHOD OF find(): Recursively goes through all the starting points
	private void find(int r, int c, ArrayList<String> steps, ArrayList<String> validWords) {
		if (r > board.length || c > board.length) {
			// Breaks out of method if not on board size
			return;
		} else if (steps.contains(r + ", " + c)) {
			// Breaks out of method if already tried this starting point
			return;
		} else {
			steps.add(r + ", " + c); // Adds bread crumb

			find(r, c, "", new ArrayList<String>(), validWords); // Checks starting point			

			// Recursive case
			find(r + 1, c, steps, validWords);
			find(r, c + 1, steps, validWords);
		}
	}

	// HELPER METHOD OF find(): Finds all possible words given a starting point
	private void find(int r, int c, String temp, ArrayList<String> steps, ArrayList<String> validWords) {
		boolean canAdd = wordList.contains(temp) && !validWords.contains(temp);

		// Cases when at limit; Adds the word and exits
		if ((r >= board.length || c >= board.length) || (r < 0 || c < 0)) {
			// Walking off the board
			if (canAdd)
				validWords.add(temp);
		} else if (temp.length() >= wordList.getLongestWordLength()) {
			// Word is impossibly long
			if (canAdd)
				validWords.add(temp);
		} else if (steps.contains(r + ", " + c)) {
			// Already walked on this path (checks bread crumbs)
			if (canAdd)
				validWords.add(temp);
		} else {

			if (canAdd)
				validWords.add(temp);

			steps.add(r + ", " + c); // Adds bread crumb
			temp += board[r][c];

			// Recursive case
			find(r + 1, c, temp, steps, validWords);
			find(r - 1, c, temp, steps, validWords);
			find(r, c + 1, temp, steps, validWords);
			find(r, c - 1, temp, steps, validWords);
			find(r + 1, c + 1, temp, steps, validWords);
			find(r + 1, c - 1, temp, steps, validWords);
			find(r - 1, c + 1, temp, steps, validWords);
			find(r - 1, c - 1, temp, steps, validWords);

			steps.remove(steps.size() - 1); // Removes bread crumb
		}
	}

	// Returns Board as a String in a square arrangement
	public String toString() {
		String s = new String();
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				s += board[r][c] + "  ";
			}
			s += "\n";
		}

		return s;
	}
}
