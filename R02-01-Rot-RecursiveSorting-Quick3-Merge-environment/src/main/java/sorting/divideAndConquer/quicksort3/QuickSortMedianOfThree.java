package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import static util.Util.swap;

import java.util.Arrays;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do
 * intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até
 * A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do
 * pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Sorts the array in such a way that its final configuration will be:
	 * 
	 * array[leftIndex] <= array[centerIndex] <= array[rightIndex]
	 * 
	 * @param array       The array from which the elements with such indexes will
	 *                    be retrieved.
	 * @param leftIndex   The index of the element which is on the far left if
	 *                    compared to the other.
	 * @param centerIndex The index of the element which is in the middle if
	 *                    compared to the other.
	 * @param rightIndex  The index of the element which is on the far right if
	 *                    compared to the other.
	 */
	private void sortThreeElements(T[] array, int leftIndex, int centerIndex, int rightIndex) {
		if (array[leftIndex].compareTo(array[centerIndex]) <= 0) {
			if (array[centerIndex].compareTo(array[rightIndex]) > 0) {
				if (array[leftIndex].compareTo(array[rightIndex]) <= 0) { // 1 3 2
					swap(array, centerIndex, rightIndex);
				} else { // 2 3 1
					swap(array, leftIndex, centerIndex);
					swap(array, leftIndex, rightIndex);
				}
			} // 1 2 3
		} else {
			if (array[leftIndex].compareTo(array[rightIndex]) <= 0) { // 2 1 3
				swap(array, centerIndex, leftIndex);
			} else if (array[centerIndex].compareTo(array[rightIndex]) <= 0) { // 3 1 2
				swap(array, centerIndex, leftIndex);
				swap(array, centerIndex, rightIndex);
			} else { // 3 2 1
				swap(array, leftIndex, rightIndex);
			}
		}
	}

	/**
	 * This algorithm chooses a pivot element and rearranges the elements of the
	 * interval in such a way that all elements lesser than the pivot go to the left
	 * part of the array and all elements greater than the pivot, go to the right
	 * part of the array.
	 * 
	 * @param array      The array that will be sorted.
	 * @param leftIndex  The index of the first element of the array which will be
	 *                   considered for sorting.
	 * @param rightIndex The index of the last element of the array which will be
	 *                   considered for sorting.
	 * @return	The position of the pivot element.
	 */
	private int partition(T[] array, int leftIndex, int rightIndex) {
		int center = (leftIndex + rightIndex) / 2;
		sortThreeElements(array, leftIndex, center, rightIndex); // Passos 1 e 2

		T pivot = array[center]; // Passo 3
		swap(array, center, rightIndex - 1); // Passo 4

		int pivotIndex = rightIndex - 1;

		for (int j = rightIndex - 2; j > leftIndex; j--) // Passo 5
			if (array[j].compareTo(pivot) >= 0) {
				pivotIndex--;
				swap(array, pivotIndex, j);
			}

		swap(array, rightIndex - 1, pivotIndex);

		return pivotIndex;
	}

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= 0 && leftIndex < rightIndex && rightIndex < array.length) {
			int pivotIndex = partition(array, leftIndex, rightIndex);
			sort(array, leftIndex, pivotIndex - 1);
			sort(array, pivotIndex + 1, rightIndex);
		}
	}
}
