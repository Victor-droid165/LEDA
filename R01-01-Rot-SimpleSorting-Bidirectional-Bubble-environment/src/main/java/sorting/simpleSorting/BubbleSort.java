package sorting.simpleSorting;

import sorting.AbstractSorting;
import static util.Util.*;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	/**
	 * Iterates over the array from left to right indexes once and pushes
	 * big elements to the right by swapping adjacent elements, until the
	 * biggest element is on the far right.
	 * 
	 * @param array      the array of elements to be bubbled.
	 * @param leftIndex  the index of the first element of the array that needs to
	 *                   be bubbled.
	 * @param rightIndex the index of the last element of the array that needs to be
	 *                   bubbled.
	 * @return a boolean that indicates if any swaps have been made.
	 */
	private boolean bubble(T[] array, int leftIndex, int rightIndex) {
		boolean swapped = false;
		for (int currentIndex = leftIndex; currentIndex < rightIndex; currentIndex++)
			if (array[currentIndex].compareTo(array[currentIndex + 1]) > 0) {
				swap(array, currentIndex, currentIndex + 1);
				swapped = true;
			}
		return swapped;
	}

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex && rightIndex > leftIndex)
			if (rightIndex < array.length && leftIndex >= 0) {
				boolean swapped;
				do {
					swapped = bubble(array, leftIndex, rightIndex);
				} while (--rightIndex > leftIndex && swapped);
			}
	}
}
