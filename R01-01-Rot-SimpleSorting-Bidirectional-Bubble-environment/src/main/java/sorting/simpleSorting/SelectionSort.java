package sorting.simpleSorting;

import sorting.AbstractSorting;
import static util.Util.*;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	/**
	 * Iterates over the array from left to right indexes looking for the smallest
	 * element in it.
	 * 
	 * @param array      the array of elements to find the smallest.
	 * @param leftIndex  the index of the first element of the array from which
	 *                   the smallest element will be select.
	 * @param rightIndex the index of the last element of the array from which
	 *                   the smallest element will be select.
	 * @return the index of the smallest element in the given range of the array.
	 */
	private int findSmallestElement(T[] array, int leftIndex, int rightIndex) {
		int smallestElementIndex = leftIndex;
		for (int currentIndex = leftIndex + 1; currentIndex <= rightIndex; currentIndex++)
			if (array[currentIndex].compareTo(array[smallestElementIndex]) < 0)
				smallestElementIndex = currentIndex;
		return smallestElementIndex;
	}

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex && rightIndex > leftIndex)
			if (rightIndex < array.length && leftIndex >= 0)
				for (int currentIndex = leftIndex; currentIndex < rightIndex; currentIndex++) {
					int smallestElementIndex = findSmallestElement(array, currentIndex, rightIndex);
					swap(array, currentIndex, smallestElementIndex);
				}
	}
}
