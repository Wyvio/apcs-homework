//Jolie Zhou
//Mr. Peterson Period 2
//This program prints out a chocolate bar.

public class AsciiArt {

	// Best effect of the SIZE of the chocolate bar is greater than 2.
	public static final int SIZE = 4;

	public static void main(String[] args) {

		for (int h = 1; h <= SIZE; h++) {
			// This is the number of rows of chocolate.
			midLine();
			for (int l = 1; l <= (SIZE / 2); l++) {
				// This is the height of an individual piece/row of chocolate.
				// THe height is half of size.
				piece();
			}
		}
		botLine();
	}

	public static void piece() {
		// This method creates a row of chocolate with a SIZE amount of SIZE pieces.
		for (int i = 1; i <= SIZE; i++) {
			// i is the number of pieces in one row.

			// This is the border of the individual piece of chocolate.
			System.out.print("|");

			for (int s = 1; s <= (SIZE - 1); s++) {
				// This is the width of one individual piece of chocolate.
				System.out.print(" ");
			}
		}

		System.out.println("|");

	}

	public static void midLine() {
		// This method creates the line that shows the break between pieces of
		// chocolate.
		System.out.print("_");
		for (int x = 1; x <= SIZE; x++) {
			for (int w = 1; w <= (SIZE - 1); w++) {
				System.out.print("=");
			}
			System.out.print("_");
		}

		System.out.println();
	}

	public static void botLine() {
		// This method creates the border of the chocolate at the bottom.
		System.out.print(" ");
		for (int x = 1; x <= SIZE; x++) {
			for (int w = 1; w <= (SIZE - 1); w++) {
				System.out.print("=");
			}
			System.out.print("'");
		}

		System.out.println();
	}
}
