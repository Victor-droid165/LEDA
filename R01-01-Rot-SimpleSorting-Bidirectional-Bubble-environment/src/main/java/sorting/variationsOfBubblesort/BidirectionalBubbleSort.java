package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import static util.Util.*;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

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
	private boolean bubbleGreatest(T[] array, int leftIndex, int rightIndex) {
		boolean swapped = false;
		for (int currentIndex = leftIndex; currentIndex < rightIndex; currentIndex++)
			if (array[currentIndex].compareTo(array[currentIndex + 1]) > 0) {
				swap(array, currentIndex, currentIndex + 1);
				swapped = true;
			}
		return swapped;
	}

	/**
	 * Iterates over the array from right to left indexes once and pushes
	 * small elements to the left by swapping adjacent elements, until the
	 * smallest element is on the far left.
	 * 
	 * @param array      the array of elements to be bubbled.
	 * @param leftIndex  the index of the first element of the array that needs to
	 *                   be bubbled.
	 * @param rightIndex the index of the last element of the array that needs to be
	 *                   bubbled.
	 * @return a boolean that indicates if any swaps have been made.
	 */
	private boolean bubbleSmallest(T[] array, int leftIndex, int rightIndex) {
		boolean swapped = false;
		for (int currentIndex = rightIndex; currentIndex > leftIndex; currentIndex--)
			if (array[currentIndex].compareTo(array[currentIndex - 1]) < 0) {
				swap(array, currentIndex, currentIndex - 1);
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
					swapped = bubbleGreatest(array, leftIndex, rightIndex);
					rightIndex--;
					if (swapped) {
						swapped = bubbleSmallest(array, leftIndex, rightIndex);
						leftIndex++;
					}
				} while (rightIndex >= leftIndex && swapped);
			}

	}
}
