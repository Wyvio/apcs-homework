/* Jolie Zhou
 * Mr. Peterson
 * Period 2 APCS
 * 14 February 2020
 * The turtle moves in a clockwise 5 by 5 square pattern.
 */
public class Turtle implements Critter {
	private int moves = 20; //set to 20 moves so resets to 0 when starts
	private int direction;
	@Override
	public char getChar() {
		return 'T';
	}

	@Override
	public int getMove(CritterInfo info) {
		moves++;
		if (moves >= 20) {  //resets moves when square completed
			moves = 0;
		}
		if (moves < 5) { //moves in predetermined pattern dependent on moves made
			direction = SOUTH;
		} else if (moves < 10) {
			direction = WEST;
		} else if (moves < 15) {
			direction = NORTH;
		} else {
			direction = EAST;
		}
		
		return direction;
	}

}
