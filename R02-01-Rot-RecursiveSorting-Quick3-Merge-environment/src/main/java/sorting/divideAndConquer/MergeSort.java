package sorting.divideAndConquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	private void merge(T[] array, int leftIndex1, int rightIndex1, int leftIndex2, int rightIndex2) {
		int start1 = leftIndex1;
		int start2 = leftIndex2;

		List<T> result = new LinkedList<T>();

		while (start1 <= rightIndex1 && start2 <= rightIndex2) {
			if (array[start1].compareTo(array[start2]) <= 0)
				result.add(array[start1++]);
			else
				result.add(array[start2++]);
		}

		while (start1 <= rightIndex1)
			result.add(array[start1++]);
		while (start2 <= rightIndex2)
			result.add(array[start2++]);

		int len1 = rightIndex1 - leftIndex1 + 1;
		int len2 = rightIndex2 - leftIndex2 + 1;
		Iterator<T> itr = result.iterator();

		while (len1-- > 0)
			array[leftIndex1++] = itr.next();
		while (len2-- > 0)
			array[leftIndex2++] = itr.next();
	}

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= 0 && leftIndex < rightIndex && rightIndex < array.length) {
			int mid = (leftIndex + rightIndex) / 2;
			sort(array, leftIndex, mid);
			sort(array, mid + 1, rightIndex);
			merge(array, leftIndex, mid, mid + 1, rightIndex);
		}
	}
}
