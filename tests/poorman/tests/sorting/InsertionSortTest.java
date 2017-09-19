package poorman.tests.sorting;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import poorman.algorithms.sorting.InsertionSort;
import poorman.algorithms.utilities.Utilities;

public class InsertionSortTest {

    static final int arraySize = 1000;
	static Double[] doubleArray = new Double[arraySize];
	static Integer[] integerArray = new Integer[arraySize];
	static String[] stringArray = new String[arraySize];
	static BigInteger[] bigIntegerArray = new BigInteger[arraySize];
	
	static InsertionSort insertionSort = new InsertionSort();
	
	
	@BeforeClass
	public static void createArrays() {

		Utilities.populateArray(doubleArray, arraySize);
		Utilities.populateArray(integerArray, arraySize);
		Utilities.populateArray(stringArray, arraySize);
		Utilities.populateArray(bigIntegerArray, arraySize);
	}
	
	
	@Test
	public void sortDouble(){
		Double[] clonedArray = insertionSort.sort(doubleArray.clone());
		Arrays.sort(doubleArray);

		Assert.assertArrayEquals(doubleArray, clonedArray);
	}
	
	@Test
	public void sortInteger(){
		Integer[] clonedArray = insertionSort.sort(integerArray.clone());
		Arrays.sort(integerArray);

		Assert.assertArrayEquals(integerArray, clonedArray);
	}
	
	@Test
	public void sortString(){
		String[] clonedArray = insertionSort.sort(stringArray.clone());
		Arrays.sort(stringArray);

		Assert.assertArrayEquals(stringArray, clonedArray);
	}
	
	@Test
	public void sortBigInteger(){
		BigInteger[] clonedArray = insertionSort.sort(bigIntegerArray.clone());
		Arrays.sort(bigIntegerArray);

		Assert.assertArrayEquals(bigIntegerArray, clonedArray);
	}
	
	@Test
	public void sortAscending() {
		Integer[] clonedArray = integerArray.clone();
		insertionSort.sortAscendingInPlace(clonedArray);
		Arrays.sort(integerArray);

		Assert.assertArrayEquals(integerArray, clonedArray);
	}
	
	@Test
	public void sortDescending() {
		Integer[] clonedArray = integerArray.clone();
		insertionSort.sortDescendingInPlace(clonedArray);
		Arrays.sort(integerArray, Collections.reverseOrder());

		Assert.assertArrayEquals(integerArray, clonedArray);
	}
	
	
}
