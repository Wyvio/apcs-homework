/* Jolie Zhou
 * Mr. Peterson
 * Period 2 APCS
 * 14 February 2020
 * The bird moves one unit randomly every time.
 */
public class Bird implements Critter {

	@Override
	public char getChar() {
		return 'B';
	}

	@Override
	public int getMove(CritterInfo info) {
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

}
