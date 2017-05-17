package poorman.algorithms.sorting;

public abstract class ParentSort {
	
	long swaps;
	long startTime;
	
	 protected <T> void swap(T[] array, int v1, int v2) {
	    swaps++;
	    T temp = array[v1];
	    array[v1] = array[v2];
	    array[v2] = temp;
	 }
	 
}
