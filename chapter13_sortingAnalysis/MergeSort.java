
/**
 * MergeSort can sort an array using the merge sort sorting algorithm.
 * 
 * @author s-zhoujo
 */

import java.util.Arrays;

public class MergeSort implements ISorter {
	/**
	 * Private fields track number of comparisons and moves, respectively
	 */
	private int numComparisons = 0;
	private int numMoves = 0;

	/**
	 * Null constructor initializes all fields to zero
	 */
	public MergeSort() {
		this.numComparisons = 0;
		this.numMoves = 0;
	}

	/**
	 * Method sorts array and returns interface for sorting results. Calls methods
	 * split(), which contains actual sorting process
	 * 
	 * @param integer array a
	 * @return ISortStats interface (SortStats object)
	 */
	@Override
	public ISortStats sort(int[] a) {
		this.numComparisons = 0;
		this.numMoves = 0;
		
		long startTime = System.nanoTime();

		split(a);

		long endTime = System.nanoTime();
		return new SortStats("MergeSort", a.length, numComparisons, numMoves, endTime - startTime);
	}

	/**
	 * 	Divides up array into sub-arrays of 1 recursively and then merges them
	 * 
	 * @param integer array a
	 */
	private void split(int[] a) {
		if (a.length > 1) {
			int[] left = Arrays.copyOfRange(a, 0, a.length / 2);
			int[] right = Arrays.copyOfRange(a, a.length / 2, a.length);

			this.split(left);
			this.split(right);

			this.merge(a, left, right);
		}
	}

	/** 
	 * Merges two arrays and saves it to the array a (parameter)
	 * 
	 * @param integer array a
	 * @param integer array left
	 * @param integer array right
	 */
	private void merge(int[] a, int[] left, int[] right) {
		int[] result = new int[left.length + right.length];

		int leftIndex = 0;
		int rightIndex = 0;

		for (int i = 0; i < result.length; i++) {
			// Check if a sub array is done
			if (leftIndex >= left.length || rightIndex >= right.length) {
				if (leftIndex >= left.length) {
					result[i] = right[rightIndex];
					rightIndex++;
				} else if (rightIndex >= right.length) {
					result[i] = left[leftIndex];
					leftIndex++;
				}
			} else {

				// Merge normally
				if (left[leftIndex] < right[rightIndex]) {
					result[i] = left[leftIndex];
					leftIndex++;
				} else {
					result[i] = right[rightIndex];
					rightIndex++;
				}
				numMoves++;
				numComparisons++;
			}
		}

		// Set original array to result array
		for (int i = 0; i < a.length; i++) {
			a[i] = result[i];
		}
	}
}
