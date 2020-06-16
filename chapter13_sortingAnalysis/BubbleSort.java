/**
 * The class that can sort an array of ints using the bubble sort sorting algorithm
 * 
 * @author s-zhoujo
 *
 */
public class BubbleSort implements ISorter {
	/**
	 * Private fields track number of comparisons and moves, respectively
	 */
	private int numComparisons;
	private int numMoves;

	/**
	 * Null constructor initializes all fields to zero
	 */
	public BubbleSort() {
		this.numComparisons = 0;
		this.numMoves = 0;
	}
	
	/**
	 * This method sorts an integer array with the bubble sort sorting algorithm.
	 * 
	 * @param integer array a
	 * @return ISortStats interface (SortStats object)
	 */

	@Override
	public ISortStats sort(int[] a) {
		this.numComparisons = 0;
		this.numMoves = 0;
		
		long startTime = System.nanoTime();

		for (int sorted = 0; sorted < a.length; sorted++) {
			// Slightly optimized to skip elements at end when already sorted
			for (int i = 0; i < a.length - sorted - 1; i++) {
				if (a[i] > a[i + 1]) {
					// Performs the swap
					int temp = a[i + 1];
					a[i + 1] = a[i];
					a[i] = temp;
					numMoves += 3;
				}
				numComparisons++;
			}
		}

		long endTime = System.nanoTime();
		return new SortStats("BubbleSort", a.length, numComparisons, numMoves, endTime - startTime);
	}
}
