import java.util.*;

/**
 * Class that contains main method and calls the various sorting algorithm classes' sort() method to test them and retrieve data about them
 *
 * @author s-zhoujo
 */

public class Program {

	/**
	 * The array of sorters to be tested
	 */
	private static ISorter[] sorters = new ISorter[] { new BubbleSort(), new SelectionSort(), new InsertionSort(),
			new MergeSort() };

	/**
	 * The main method that tests all the algorithms. Runs tests on randomized
	 * integer arrays from 1 to 4096 by powers of two, an array with 4096 random
	 * integers in descending order, and then an array with 4096 random integers in
	 * ascending order.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] test;

		// 1. Random tests, increasing size
		for (int i = 1; i <= 4096; i *= 2) {
			test = new int[i];
			randomize(test);
			testSorters(test);
		}

		// 2. Reverse tests
		test = new int[4096];
		reverseOrder(test);
		testSorters(test);

		// 3. Ordered tests
		test = new int[4096];
		inOrder(test);
		testSorters(test);
	}

	/**
	 * Private method that copies the array to be tested for each sorting algorithm,
	 * tests it, saves the results, and then checks it for all sorters
	 * 
	 * @param integer array a (to be tested)
	 * @throws RuntimeException if check fails
	 */
	private static void testSorters(int[] a) {
		for (int i = 0; i < sorters.length; i++) {
			int[] test = a.clone();
			System.out.println((sorters[i].sort(test)));

			if (!Check.isInOrder(test)) {
				throw new RuntimeException(sorters[i].getClass().getName() + " failed! :(");
			}
		}
	}

	/**
	 * Randomizes an integer array with integers from a Random object
	 * 
	 * @param integer array a
	 */
	private static void randomize(int[] a) {
		Random random = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = random.nextInt();
		}
	}

	/**
	 * Puts random integers in an array in descending order
	 * 
	 * @param integer array a
	 */
	private static void reverseOrder(int[] a) {
		Random random = new Random();
		for (int i = 0, x = Integer.MAX_VALUE; i < a.length; i++, x -= random.nextInt(4086)) {
			a[i] = x;
		}
	}

	/**
	 * Puts random integers in an array in ascending order
	 * 
	 * @param integer array a
	 */
	private static void inOrder(int[] a) {
		reverseOrder(a);
		new MergeSort().sort(a);
	}
}
