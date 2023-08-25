package sorting.divideAndConquer.hybridMergesort;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import sorting.AbstractSorting;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de
 * forma
 * que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados.
 * E a cada chamada
 * interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 * INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	/**
	 * Merges one sorted range of values from leftIndex1 to rightIndex1 with other
	 * sorted range of values from leftIndex2 to rightIndex2 into one single sorted
	 * list, then puts the final sorted values in the same ranges in the array.
	 * 
	 * @param array       The array that's being sorted.
	 * @param leftIndex1  The index of the first element of the first subarray.
	 * @param rightIndex1 The index of the last element of the first subarray.
	 * @param leftIndex2  The index of the first element of the second subarray.
	 * @param rightIndex2 The index of the last element of the second subarray.
	 */
	private void merge(T[] array, int leftIndex1, int rightIndex1, int leftIndex2, int rightIndex2) {
		MERGESORT_APPLICATIONS++;

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

	/**
	 * Inserts the current element (i.e., the element after the last one that was
	 * sorted) in the correct position of the left part of the
	 * array which is already sorted.
	 * 
	 * @param array                  The array that's being sorted.
	 * @param leftIndex              the index of the first element of the array.
	 * @param lastSortedElementIndex the index of the last sorted element.
	 */
	private void insertion(T[] array, int leftIndex, int lastSortedElementIndex) {
		INSERTIONSORT_APPLICATIONS++;
		T element = array[lastSortedElementIndex + 1];

		while (lastSortedElementIndex >= leftIndex && array[lastSortedElementIndex].compareTo(element) > 0) {
			array[lastSortedElementIndex + 1] = array[lastSortedElementIndex];
			lastSortedElementIndex--;
		}
		array[lastSortedElementIndex + 1] = element;
	}

	/**
	 * Sorts the array from left to right indexes by putting each element in its
	 * correct place.
	 * 
	 * @param array
	 * @param leftIndex
	 * @param rightIndex
	 */
	private void insertionSort(T[] array, int leftIndex, int rightIndex) {
		for (int currentIndex = leftIndex + 1; currentIndex <= rightIndex; currentIndex++)
			insertion(array, leftIndex, currentIndex - 1);
	}

	public void sort(T[] array, int leftIndex, int rightIndex) {

		MERGESORT_APPLICATIONS = 0;
		INSERTIONSORT_APPLICATIONS = 0;

		if (leftIndex >= 0 && leftIndex < rightIndex && rightIndex < array.length) {
			if (rightIndex - leftIndex + 1 <= SIZE_LIMIT) {
				insertionSort(array, leftIndex, rightIndex);
			} else {
				int mid = (leftIndex + rightIndex) / 2;

				sort(array, leftIndex, mid);
				int lastInsertionApps = INSERTIONSORT_APPLICATIONS;

				sort(array, mid + 1, rightIndex);
				INSERTIONSORT_APPLICATIONS += lastInsertionApps;

				merge(array, leftIndex, mid, mid + 1, rightIndex);
			}
		}
	}
}
