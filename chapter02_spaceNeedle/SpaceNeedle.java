//Jolie Zhou
//APCS Peterson Period 2
//This program prints the iconic Seattle Space Needle
//while allowing you to customize and choose its size!

public class SpaceNeedle {
	public static final int SIZE = 4;

	public static void main(String[] args) {

		pillarThin();

		dome();

		pillarThin();

		pillarThick();

		// Creates the base to the ground
		triangle();

	}

	public static void dome() {
		// Creates the round-ish shape at the top of the Needle
		
		// Top Portion of Dome
		triangle();

		// Bottom Portion of Dome

		for (int rows = 1; rows <= SIZE; rows++) {
			// Spaces
			for (int s = (2 * (rows - 1)); s >= 1; s--) {
				System.out.print(" ");
			}

			// Back Slash and Underscore
			System.out.print("\\_");

			// Mountain Shapes
			for (int m = 1; m <= ((SIZE * 3 - 1) - ((rows - 1) * 2)); m++) {
				System.out.print("/\\");
			}

			// Underscore and Forward Slash & Create a new line
			System.out.println("_/");
		}
	}

	public static void triangle() {
		// Creates a triangle shape featuring : as a pattern
		
		// Increasing Rows Section

		for (int rows = 1; rows <= SIZE; rows++) {
			// Spaces
			for (int s = 1; s <= (3 * (SIZE - rows)); s++) {
				System.out.print(" ");
			}

			// Underscore (2)
			System.out.print("__");

			// Forward Slash
			System.out.print("/");

			// Colons
			for (int c = 1; c <= (3 * (rows - 1)); c++) {
				System.out.print(":");
			}

			// Thin Pillar
			System.out.print("||");

			// Colons
			for (int c = 1; c <= (3 * (rows - 1)); c++) {
				System.out.print(":");
			}

			// Backward Slash
			System.out.print("\\");

			// Underscore (2) & creates new line
			System.out.println("__");
		}

		// Bottom Bar

		// Vertical Line
		System.out.print("|");

		// Double Quotes (Symmetrical: One Side is SIZE * 3)
		for (int q = 1; q <= (SIZE * 6); q++) {
			System.out.print("\"");
		}

		// Vertical Line & creates new line
		System.out.println("|");

	}

	public static void pillarThin() {
		// Creates a pillar featuring || pattern
		
		for (int i = 1; i <= SIZE; i++) {

			// Spaces
			for (int s = 1; s <= (SIZE * 3); s++) {
				System.out.print(" ");
			}

			// 2 Vertical Lines & Creates new line
			System.out.println("||");
		}
	}

	public static void pillarThick() {
		// Creates a pillar featuring the |%%||%%| pattern
		
		// Height
		for (int h = 1; h <= (SIZE * SIZE); h++) {
			// Spaces
			for (int s = 1; s <= (SIZE * 3 - (SIZE - 1)); s++) {
				System.out.print(" ");
			}

			// Symmetrical: Repeats Twice
			for (int i = 1; i <= 2; i++) {
				// Vertical Line
				System.out.print("|");

				// Percentage Signs (SIZE - 2)
				for (int p = 1; p <= (SIZE - 2); p++) {
					System.out.print("%");
				}

				// Vertical Line
				System.out.print("|");
			}

			// New Line
			System.out.println();
		}
	}
}
