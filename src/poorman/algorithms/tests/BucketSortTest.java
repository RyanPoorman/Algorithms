package poorman.algorithms.tests;


import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import poorman.algorithms.sorting.BogoSort;
import poorman.algorithms.utilities.Utilities;


public class BucketSortTest {

	    static final int arraySize = 10;
		static Double[] doubleArray = new Double[arraySize];
		static Integer[] integerArray = new Integer[arraySize];
		static String[] stringArray = new String[arraySize];
		static BigInteger[] bigIntegerArray = new BigInteger[arraySize];
		
		static BogoSort bogoSort = new BogoSort();
		
		
		@BeforeClass
		public static void createArrays() {
			Utilities.populateArray(doubleArray, arraySize);
			Utilities.populateArray(integerArray, arraySize);
			Utilities.populateArray(stringArray, arraySize);
			Utilities.populateArray(bigIntegerArray, arraySize);
		}
		
		
		@Test
		public void sortDouble(){
			Double[] clonedArray = bogoSort.sort(doubleArray.clone());
			Arrays.sort(doubleArray);
			Assert.assertArrayEquals(doubleArray, clonedArray);
		}
		
		@Test
		public void sortInteger(){
			Integer[] clonedArray = bogoSort.sort(integerArray.clone());
			Arrays.sort(integerArray);
			Assert.assertArrayEquals(integerArray, clonedArray);
		}
		
		@Test
		public void sortString(){
			String[] clonedArray = bogoSort.sort(stringArray.clone());
			Arrays.sort(stringArray);
			Assert.assertArrayEquals(stringArray, clonedArray);
		}
		
		@Test
		public void sortBigInteger(){
			BigInteger[] clonedArray = bogoSort.sort(bigIntegerArray.clone());
			Arrays.sort(bigIntegerArray);
			Assert.assertArrayEquals(bigIntegerArray, clonedArray);
		}
		
		@Test
		public void sortAscending() {
			Integer[] clonedArray = integerArray.clone();
			bogoSort.sortAscendingInPlace(clonedArray);
			Arrays.sort(integerArray);
			Assert.assertArrayEquals(integerArray, clonedArray);
		}
		
		@Test
		public void sortDescending() {
			Integer[] clonedArray = integerArray.clone();
			bogoSort.sortDescendingInPlace(clonedArray);
			Arrays.sort(integerArray, Collections.reverseOrder());
			Assert.assertArrayEquals(integerArray, clonedArray);
		}
		
}


