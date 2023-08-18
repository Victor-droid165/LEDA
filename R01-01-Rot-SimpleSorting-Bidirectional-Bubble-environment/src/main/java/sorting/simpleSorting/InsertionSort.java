package sorting.simpleSorting;

import sorting.AbstractSorting;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	/**
	 * Inserts the current element (i.e., the element after the last one that was
	 * sorted) in the correct position of the left part of the
	 * array which is already sorted.
	 * 
	 * @param array                  The array that's being sorted.
	 * @param leftIndex              the index of the first element of the array.
	 * @param lastSortedElementIndex the index of the last sorted element.
	 */
	private void insert(T[] array, int leftIndex, int lastSortedElementIndex) {
		T element = array[lastSortedElementIndex + 1];

		while (lastSortedElementIndex >= leftIndex && array[lastSortedElementIndex].compareTo(element) > 0) {
			array[lastSortedElementIndex + 1] = array[lastSortedElementIndex];
			lastSortedElementIndex--;
		}
		array[lastSortedElementIndex + 1] = element;
	}

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex && rightIndex > leftIndex)
			if (rightIndex < array.length && leftIndex >= 0)
				for (int currentIndex = leftIndex + 1; currentIndex <= rightIndex; currentIndex++)
					insert(array, leftIndex, currentIndex - 1);
	}
}
