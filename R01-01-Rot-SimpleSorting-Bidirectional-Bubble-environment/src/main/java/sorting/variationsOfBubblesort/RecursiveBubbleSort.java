package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import static util.Util.*;

public class RecursiveBubbleSort<T extends Comparable<T>> extends
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
	 */
	private void bubble(T[] array, int leftIndex, int rightIndex) {
		if(rightIndex > leftIndex){
			if (array[leftIndex].compareTo(array[leftIndex + 1]) > 0)
				swap(array, leftIndex, leftIndex + 1);
			bubble(array, leftIndex + 1, rightIndex);
		}
	}

	/**
	 * Implementação recursiva do bubble sort. Você deve implementar apenas esse
	 * método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex && rightIndex > leftIndex)
			if (rightIndex < array.length && leftIndex >= 0) {
				bubble(array, leftIndex, rightIndex);
				sort(array, leftIndex, rightIndex - 1);
			}
	}

}
