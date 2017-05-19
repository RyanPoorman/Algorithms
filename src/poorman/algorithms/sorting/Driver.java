package poorman.algorithms.sorting;


public class Driver {

	final static int arrayLength = 1000; 
	
	public static void main(String[] args) {
		
		Integer[] test = new Integer[arrayLength];
		Utilities.populateArray(test, arrayLength);
	    long startTime = System.currentTimeMillis();
		new InsertionSort().sortAscending(test);
		System.out.println("Time to sort: " + (startTime-System.currentTimeMillis())*-1 + " ms");
		Utilities.printArray(test);
		
		
	}

	



}
