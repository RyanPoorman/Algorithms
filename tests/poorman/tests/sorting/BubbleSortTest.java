package poorman.tests.sorting;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import poorman.algorithms.sorting.BubbleSort;
import poorman.algorithms.utilities.Utilities;

public class BubbleSortTest {

	static final int arraySize = 100;
	static Double[] doubleArray = new Double[arraySize];
	static Integer[] integerArray = new Integer[arraySize];
	static String[] stringArray = new String[arraySize];
	static BigInteger[] bigIntegerArray = new BigInteger[arraySize];

	static BubbleSort bubbleSort = new BubbleSort();

	@BeforeClass
	public static void createArrays() {

		Utilities.populateArray(doubleArray, arraySize);
		Utilities.populateArray(integerArray, arraySize);
		Utilities.populateArray(stringArray, arraySize);
		Utilities.populateArray(bigIntegerArray, arraySize);
	}

	@Test
	public void sortDouble() {
		Double[] clonedArray = bubbleSort.sort(doubleArray.clone());
		Arrays.sort(doubleArray);

		Assert.assertArrayEquals(doubleArray, clonedArray);
	}

	@Test
	public void sortInteger() {
		Integer[] clonedArray = bubbleSort.sort(integerArray.clone());
		Arrays.sort(integerArray);

		Assert.assertArrayEquals(integerArray, clonedArray);
	}

	@Test
	public void sortString() {
		String[] clonedArray = bubbleSort.sort(stringArray.clone());
		Arrays.sort(stringArray);

		Assert.assertArrayEquals(stringArray, clonedArray);
	}

	@Test
	public void sortBigInteger() {
		BigInteger[] clonedArray = bubbleSort.sort(bigIntegerArray.clone());
		Arrays.sort(bigIntegerArray);

		Assert.assertArrayEquals(bigIntegerArray, clonedArray);
	}

	@Test
	public void sortAscending() {
		Integer[] clonedArray = integerArray.clone();
		bubbleSort.sortAscendingInPlace(clonedArray);
		Arrays.sort(integerArray);

		Assert.assertArrayEquals(integerArray, clonedArray);
	}

	@Test
	public void sortDescending() {
		Integer[] clonedArray = integerArray.clone();
		bubbleSort.sortDescendingInPlace(clonedArray);
		Arrays.sort(integerArray, Collections.reverseOrder());

		Assert.assertArrayEquals(integerArray, clonedArray);
	}

}
