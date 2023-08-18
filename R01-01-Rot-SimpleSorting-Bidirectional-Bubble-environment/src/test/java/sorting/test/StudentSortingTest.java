package sorting.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.simpleSorting.BubbleSort;
import sorting.simpleSorting.InsertionSort;
import sorting.simpleSorting.SelectionSort;
import sorting.variationsOfBubblesort.BidirectionalBubbleSort;
import sorting.variationsOfBubblesort.RecursiveBubbleSort;
import sorting.variationsOfSelectionsort.RecursiveSelectionSort;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;

	public AbstractSorting<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });

		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		this.implementation = new RecursiveSelectionSort<Integer>();
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE

	public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if (array.length > 0) {
			copy1 = Arrays.copyOf(array, array.length);
		}
		implementation.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	public void genericTestInRange(Integer[] array, int leftIndex, int rightIndex) {
		Integer[] copy1 = {};
		if (array.length > 0) {
			copy1 = Arrays.copyOf(array, array.length);
		}

		implementation.sort(array, leftIndex, rightIndex);
		Arrays.sort(copy1, leftIndex, rightIndex + 1);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testSort01() {
		genericTest(vetorTamPar);
	}

	@Test
	public void testSort02() {
		genericTest(vetorTamImpar);
	}

	@Test
	public void testSort03() {
		genericTest(vetorVazio);
	}

	@Test
	public void testSort04() {
		genericTest(vetorValoresIguais);
	}

	@Test
	public void testSort05() {
		genericTest(vetorValoresRepetidos);
	}

	@Test
	public void testSortInRange01() {
		genericTestInRange(vetorTamPar, 0, 2);
	}

	@Test
	public void testSortInRange02() {
		genericTestInRange(vetorTamImpar, 2, 2);
	}

	@Test
	public void testSortInRange03() {
		genericTestInRange(vetorValoresRepetidos, 5, 7);
	}

	@Test
	public void testSortInRange04() {
		genericTestInRange(vetorValoresIguais, 0, vetorValoresIguais.length - 1);
	}

	@Test
	public void testSortOutOfBounds01(){
		Integer[] copy1 = {};
		if (vetorTamImpar.length > 0) {
			copy1 = Arrays.copyOf(vetorTamImpar, vetorTamImpar.length);
		}

		implementation.sort(vetorTamImpar, 0, vetorTamImpar.length);
		Assert.assertArrayEquals(copy1, vetorTamImpar);
	}


	@Test
	public void testSortOutOfBounds02(){
		Integer[] copy1 = {};
		if (vetorTamPar.length > 0) {
			copy1 = Arrays.copyOf(vetorTamPar, vetorTamPar.length);
		}

		implementation.sort(vetorTamPar, -1, 3);
		Assert.assertArrayEquals(copy1, vetorTamPar);
	}

	@Test
	public void testSortOutOfBounds03(){
		Integer[] copy1 = {};
		if (vetorTamPar.length > 0) {
			copy1 = Arrays.copyOf(vetorTamPar, vetorTamPar.length);
		}

		implementation.sort(vetorTamPar, -1, vetorTamPar.length);
		Assert.assertArrayEquals(copy1, vetorTamPar);
	}

	@Test
	public void testSortLimitsInvalid01(){
		Integer[] copy1 = {};
		if (vetorValoresRepetidos.length > 0) {
			copy1 = Arrays.copyOf(vetorValoresRepetidos, vetorValoresRepetidos.length);
		}

		implementation.sort(vetorValoresRepetidos, 5, 3);
		Assert.assertArrayEquals(copy1, vetorValoresRepetidos);
	}

	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
	 * UMA PARTE DO ARRAY.
	 */
}