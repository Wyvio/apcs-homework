/* Jolie Zhou
 * Mr. Peterson
 * Period 2 APCS
 * 14 February 2020
 */

public class Junior implements Student {
	private int moves = 4;
	private int direction = CENTER;
	private int play = 0; // default rock, copies enemy's previous move
	private int score = 0;

	@Override
	public int getScore() {
		return score;
	}

	@Override
	public char getChar() {
		return 'J';
	}

	@Override
	public int getMove(StudentInfo info) {
		// Generates random number to choose direction
		double random = Math.random() * 4;
		moves++;
		if (moves == 3) { // Pauses if moved 3 times already
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
		return play;
	}

	public void setPlay(int play) {
		this.play = play;
	}

	public void won() {
		score++;
	}

}
