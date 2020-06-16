/**
 * SelectionSort can sort an array using the selection sort sorting algorithm.
 * 
 * @author s-zhoujo
 *
 */
public class SelectionSort implements ISorter {
	
	/**
	 * Private fields track number of comparisons and moves, respectively
	 */
	private int numComparisons;
	private int numMoves;

	/**
	 * Null constructor initializes all fields to zero
	 */
	public SelectionSort() {
		this.numComparisons = 0;
		this.numMoves = 0;
	}

	/**
	 * Method sorts array and returns interface for sorting results
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
			int least = sorted;
			// Slightly optimized to skip sorted starting elements
			for (int i = sorted; i < a.length; i++) {
				if (a[i] < a[least]) {
					least = i;
				}
				numComparisons++;
			}
			// Swaps the elements
			int temp = a[sorted];
			a[sorted] = a[least];
			a[least] = temp;
			numMoves += 3;

		}

		long endTime = System.nanoTime();
		return new SortStats("SelectionSort", a.length, numComparisons, numMoves, endTime - startTime);
	}

}
