
public class LoopPractice {
	public static final int SIZE = 4;

	public static void main(String[] args) {
		triangle();
	}

	public static void triangle() {
		for (int i = 1; i <= SIZE; i++) {
			for (int h = 1; h <= SIZE; h++) {
				for (int a = 1; a <= SIZE - (i - 1); a++) {
					for (int s = 1; s <= SIZE - (h - 1); s++) {
						System.out.print("/");
					}
					for (int s = 1; s <= (h - 1); s++) {
						System.out.print(" ");
					}
				}

				System.out.println();
			}
		}
	}
}
