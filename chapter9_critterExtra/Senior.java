/* Jolie Zhou
 * Mr. Peterson
 * Period 2 APCS
 * 14 February 2020
 */
public class Senior implements Student {
	private int moves = 4;
	private int direction = CENTER;
	private int score = 0;
	private int play = 3;

	private int playCounter = 0;

	@Override
	public int getScore() {
		return score;
	}

	@Override
	public char getChar() {
		return 'S';
	}

	@Override
	public int getMove(StudentInfo info) {// Generates random number to choose direction
		double random = Math.random() * 4;
		moves++;
		if (moves == 2) { // Pauses if moved 2 times already
			direction = CENTER;
		} else if (moves > 3) { // Changes direction if moved more than 3 times (after pause)
			moves = 0;
			if (random < 1) {
				direction = NORTH;
			} else if (random < 2) {
				direction = SOUTH;
			} else if (random < 3) {
				direction = EAST;
			} else {
				direction = WEST;
			}
		}

		return direction;
	}

	@Override
	public int getPlay() {
		playCounter++;

		if (playCounter == 1) {
			play = SCISSORS;
		} else if (playCounter == 3) {
			play = PAPER;
			playCounter = 0;
		}
		return play;
	}

	@Override
	public void won() {
		score = getScore() + 1;
	}

}
