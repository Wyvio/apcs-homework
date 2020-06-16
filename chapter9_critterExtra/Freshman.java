/* Jolie Zhou
 * Mr. Peterson
 * Period 2 APCS
 * 14 February 2020
 * 
 * Freshmen play random moves and walk randomly.
 */
public class Freshman implements Student {
	private int score = 0;

	@Override
	public int getScore() {
		return score;
	}

	@Override
	public char getChar() {
		return 'F';
	}

	@Override
	public int getMove(StudentInfo info) {
		// Generates random number to decide direction; always moving
		double random = Math.random() * 4;
		int direction;
		if (random < 1) {
			direction = NORTH;
		} else if (random < 2) {
			direction = SOUTH;
		} else if (random < 3) {
			direction = EAST;
		} else {
			direction = WEST;
		}
		return direction;
	}

	@Override
	public int getPlay() {
		// Generates random number to decide play
		double random = Math.random() * 3;
		int play;
		if (random < 1) {
			play = ROCK;
		} else if (random < 2) {
			play = PAPER;
		} else {
			play = SCISSORS;
		}
		return play;
	}

	@Override
	public void won() {
		score++;
	}

}
