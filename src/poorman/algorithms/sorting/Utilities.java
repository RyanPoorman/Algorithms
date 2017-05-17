package poorman.algorithms.sorting;

import java.util.Random;

public class Utilities {
	public static void populateArray(Integer[] test, int arrayLength) {

		Random rand = new Random();
		
		for(int i = 0; i < arrayLength; i++) {
			test[i] = rand.nextInt(1000);
		}
	}
	
	public static void printArray(Integer[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
			
		}
	}
}
