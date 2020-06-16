/* Jolie Zhou
 * Mr. Peterson
 * Period 2 APCS
 * 14 February 2020
 */
public class Sophmore implements Student {
	private int moves = 3;
	private int direction = CENTER;
	private int play = ROCK; // default rock, copies enemy's previous move
	private int score = 0;

	@Override
	public int getScore() {
		return score;
	}

	@Override
	public char getChar() {
		return 'T';

	}

	@Override
	public int getMove(StudentInfo info) {// Generates random number to choose direction
		double random = Math.random() * 4;
		moves++;
		if (moves >= 3) { // chooses new direction if moved 3 times already
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

	@Override
	public void won() {
		score++;
	}

}
