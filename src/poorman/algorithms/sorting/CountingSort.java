package poorman.algorithms.sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CountingSort {
	private int minVal = 0;
	private int maxVal = 0;
	int[] counts;
	
	public <T extends Comparable<T>> void sort(Integer[] array) {
    
	    Integer[] clonedArray = array.clone();
	    
	    setMinMaxValues(array);
	 
	    findFrequencies(array);
	    
	    for (int i = 0; i <= array.length-1; i++) {
	        array[counts[clonedArray[i] - minVal]--] = clonedArray[i];
	    }
	}

	private void setMinMaxValues(Integer[] array) {
	   for (int i = 1; i < array.length; i++) {
	      if (array[i] < minVal) {
	    	  minVal = array[i];
	      } else if (array[i] > maxVal) {
	    	  maxVal = array[i];
	      }
		}
	}

	private void findFrequencies(Integer[] array) {
	    counts = new int[maxVal - minVal + 1];
	 
	    for (int i = 0;  i < array.length; i++) {
	      counts[array[i] - minVal]++;
	    }
	 
	    counts[0]--;
	    for (int i = 1; i < counts.length; i++) {
	      counts[i] = counts[i] + counts[i-1];
	    }
	}

	

	
}