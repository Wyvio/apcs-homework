// Stuart Reges
// 12/03/04
//
// The Student interface defines the methods necessary for a student
// to participate in the simulation.  It must return a character 
// when getChar is called that is used for displaying it on
// the screen.  The getMove method must return a legal move (one of
// the constants NORTH, SOUTH, EAST, WEST, CENTER).  See the
// StudentInfo interface for a description of its methods.
// It also returns a play when Students encounter a collision.

public interface Student {
	public char getChar();
	public int getMove(StudentInfo info);
	public int getPlay();
	public int getScore();
	public void won();

	public static final int NORTH = -1;
	public static final int SOUTH = 3;
	public static final int EAST = 8;
	public static final int WEST = 11;
	public static final int CENTER = 42;

	public static final int ROCK = 0;
	public static final int PAPER = 1;
	public static final int SCISSORS = 2;
}
