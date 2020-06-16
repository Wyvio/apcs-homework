/* Jolie Zhou
 * Mr. Peterson
 * Period 2 APCS
 * 14 February 2020
 * The wolf runs away from other critters to maximize their rate of survival.
 */

public class Wolf implements Critter {
	private int direction;
	private static final char[] CRITTERS = { 'B', 'F', 'T', 'O', 'W' };

	@Override
	public char getChar() {
		return 'W';
	}

	@Override
	public int getMove(CritterInfo info) {

		// Sets directions to move away from closest critter
		this.setDirection(info, CRITTERS);

		return direction;

	}

	// Finds direction of a critter and moves away from it; if it is continuously
	// running, it does a sharp turn back
	private int setDirection(CritterInfo info, char[] critter) {
		int direction = CENTER;
		int cDirection = CENTER;
		char following = '.';

		// Loops through all the critters' ids and finds the direction
		for (int i = 0; i < critter.length; i++) {

			if (info.getNeighbor(NORTH) == critter[i]) {
				cDirection = NORTH;
				direction = SOUTH;
				following = critter[i];
			} else if (info.getNeighbor(EAST) == critter[i]) {
				cDirection = EAST;
				direction = WEST;
				following = critter[i];
			} else if (info.getNeighbor(SOUTH) == critter[i]) {
				cDirection = SOUTH;
				direction = NORTH;
				following = critter[i];
			} else if (info.getNeighbor(WEST) == critter[i]) {
				cDirection = WEST;
				direction = EAST;
				following = critter[i];
			}
		}

		// if continuously running one way, reverse
		if (this.direction == direction) {
			direction = cDirection;
		}

		this.direction = direction;

		return direction;

	}
}
