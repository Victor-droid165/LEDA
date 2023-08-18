package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;
import static util.Util.*;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

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
		if(rightIndex > leftIndex){
			int nextSmallestElementIndex = findSmallestElement(array, leftIndex + 1, rightIndex);
			if(array[nextSmallestElementIndex].compareTo(array[smallestElementIndex]) < 0)
				smallestElementIndex = nextSmallestElementIndex;
		}
			
		return smallestElementIndex;
	}

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex && rightIndex > leftIndex)
			if (rightIndex < array.length && leftIndex >= 0) {
				int smallestElementIndex = findSmallestElement(array, leftIndex, rightIndex);
				swap(array, leftIndex, smallestElementIndex);

				sort(array, leftIndex + 1, rightIndex);
			}
	}

}
