/* Jolie Zhou
 * Mr Peterson Period 2
 * Prints a custom plaque featuring your name Example:
 *
 *     _ ______________________________ 
 *    / /                              \
 *   / /       .------..------.        /
 *  / /       /      WOW!     /       /
 * / /        '------''------'       /  
 * \ \______________________________/*/

public class AsciiArt2 {
	public static final int SIZE = 21;
	// Please select a phrase the same length as the SIZE. (Best Results if greater than 2)
	public static final String WORD = "Mr. Peterson is cool!"; 

	public static int rows = 0;

	public static int spaceNum;

	public static void main(String[] args) {
		// ROW 0 : The top of the bar
		spaceNum = SIZE + 1;
		spaces();

		System.out.print("_ ");
		borderSide();
		System.out.println();

		// ROW 1
		borderLeft();

		// empty spaces for row 1
		spaceNum = SIZE * 8 - 2;
		spaces();

		System.out.println("\\");

		// ROW 2
		borderLeft();
		spaceNum = SIZE * 2 - 1;
		spaces();

		// prints symmetrical pattern .------. (scalable)
		for (int i = 1; i <= 2; i++) {

			System.out.print(".");

			patternDashes();

			System.out.print(".");
		}

		// empty spaces
		spaceNum = SIZE * 2;
		spaces();

		System.out.println("/");

		// ROW 3
		borderLeft();
		spaceNum = SIZE * 2 - 1;
		spaces();

		// total space of size*4 - 1
		System.out.print("/");

		spaceNum = (int) (SIZE * 1.5 + SIZE % 2);
		spaces();

		System.out.print(WORD); // SIZE length

		spaceNum = (int) (SIZE * 1.5 - 1);
		spaces();

		System.out.print("/");

		spaceNum = SIZE * 2 - 1;
		spaces();
		System.out.println("/");

		// ROW 4
		borderLeft();
		spaceNum = SIZE * 2;
		spaces();

		// prints symmetrical pattern '------' (scalable)
		for (int i = 1; i <= 2; i++) {

			System.out.print("'");

			patternDashes();

			System.out.print("'");
		}

		spaceNum = SIZE * 2 - 1;
		spaces();

		System.out.println("/");

		// ROW 5
		spaceNum = SIZE - (rows - 1);
		spaces();

		System.out.print("\\ \\");

		borderSide();
		System.out.println("/");

	}

	public static void borderSide() {
		for (int s = 1; s <= (SIZE * 8 - 2); s++) {
			System.out.print("_");
		}
	}

	public static void borderLeft() {
		rows += 1;
		for (int s = 1; s <= (SIZE - (rows - 1)); s++) {
			System.out.print(" ");
		}

		System.out.print("/ /");
	}

	public static void spaces() {
		for (int s = 1; s <= spaceNum; s++) {
			System.out.print(" ");
		}
	}

	public static void patternDashes() {
		for (int s = 1; s <= (SIZE * 2 - 2); s++) {
			System.out.print("-");
		}
	}
}
