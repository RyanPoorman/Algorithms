package poorman.algorithms.utilities;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Utilities {
	public static void populateArray(Object[] array, int arrayLength) {

		Random rand = new Random();
		
	
		if(array instanceof Double[])
			popualateDouble(array, rand, arrayLength);
		else if(array instanceof Integer[])
			popualateInteger(array, rand, arrayLength);
		else if(array instanceof String[])
			popualateString(array, rand, arrayLength);
		else if (array instanceof BigInteger[])
			popualateBigInteger(array, rand, arrayLength);
	
		
	}
	
	
	
	private static void popualateBigInteger(Object[] array, Random rand, int arrayLength) {
		for(int i = 0; i < arrayLength; i++) {
			array[i] = new BigInteger(2, rand);
		}
	}

	private static void popualateString(Object[] array, Random rand, int arrayLength) {
		for(int i = 0; i < arrayLength; i++) {
			array[i] = createString(rand);
		}
	}

	private static String createString(Random rand) {
		
		char[] charArray = new char[10];
		
		for(int i = 0; i < 10; i++){
			charArray[i] = (char)ThreadLocalRandom.current().nextInt(65, 90 + 1);
		}
		return new String(charArray);
	}



	private static void popualateInteger(Object[] array, Random rand, int arrayLength) {
		for(int i = 0; i < arrayLength; i++) {
			array[i] = rand.nextInt();
		}
	}

	private static void popualateDouble(Object[] array, Random rand, int arrayLength) {
		for(int i = 0; i < arrayLength; i++) {
			array[i] = rand.nextDouble();
		}
	}



	public static <T> void printArray(T[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	

	
	public static void printArrayAsList(Object[] array){
		System.out.println(Arrays.asList(array)+"\r\n --------------------------------------------------------------\r\n");
	}
}
