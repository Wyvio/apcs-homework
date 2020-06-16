/* Jolie Zhou
 * Mr. Peterson
 * Period 2 APCS
 * 14 February 2020
 * The OldTurtle is like the turtle but moves every other time in a slow square.
 */
public class OldTurtle implements Critter {
	private int moves = 40; // set to 40 moves so resets to 0 when starts
	private int direction;

	@Override
	public char getChar() {
		return 'O';
	}

	@Override
	public int getMove(CritterInfo info) {

		moves++;

		if (moves % 2 == 0) { // moves if number of moves are even (every other one)
			if (moves >= 40) {
				moves = 0;
			}
			if (moves < 10) { // moves in predetermined sequence
				direction = SOUTH;
			} else if (moves < 20) {
				direction = WEST;
			} else if (moves < 30) {
				direction = NORTH;
			} else {
				direction = EAST;
			}
		} else { // does not move if number of moves is not even (every other one)
			direction = CENTER;
		}

		return direction;
	}

}
