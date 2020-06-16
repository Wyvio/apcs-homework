/**
 * InsertionSort can sort an array using the insertion sort sorting algorithm.
 * 
 * @author s-zhoujo
 *
 */

public class InsertionSort implements ISorter {

	/**
	 * Private fields track number of comparisons and moves, respectively
	 */
	private int numComparisons;
	private int numMoves;

	/**
	 * Null constructor initializes all fields to zero
	 */
	public InsertionSort() {
		this.numComparisons = 0;
		this.numMoves = 0;
	}

	/**
	 * Sorts the array and returns interface for results
	 * 
	 * @param integer array a
	 * @return ISortStats interface SortStats object
	 */
	@Override
	public ISortStats sort(int[] a) {
		this.numComparisons = 0;
		this.numMoves = 0;
		
		long startTime = System.nanoTime();

		for (int sorted = 0; sorted < a.length - 1; sorted++) {
			int current = sorted + 1;
			for (int i = 0; i <= sorted; i++) {
				if (a[current] < a[i]) {
					int temp = a[current];
					numMoves++;
					for (int s = sorted; s >= i; s--) {
						a[s + 1] = a[s];
						numMoves++;
					}
					a[i] = temp;
					numMoves++;
				}
				numComparisons++;
			}
		}
		long endTime = System.nanoTime();
		return new SortStats("InsertionSort", a.length, numComparisons, numMoves, endTime - startTime);
	}

}
