/* Jolie Zhou
 * Mr. Peterson
 * Period 2 APCS
 * 14 February 2020
 * The frog is like the bird but moves 3 units in a random direction.
 */
public class Frog implements Critter {
	private int moves = 3; // Set to 3 moves so it chooses a new direction when started
	private int direction;

	@Override
	public char getChar() {
		return 'F';
	}

	@Override
	public int getMove(CritterInfo info) {
		// Generates random number to choose direction
		double random = Math.random() * 4;
		moves++;
		if (moves >= 3) { //chooses new direction if moved 3 times already
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

}
