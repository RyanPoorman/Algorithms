package poorman.algorithms.sorting;

public abstract class ParentSorter {

	long swaps;
	long startTime;

	protected <T> void swap(T[] array, int v1, int v2) {
		swaps++;
		T temp = array[v1];
		array[v1] = array[v2];
		array[v2] = temp;
	}

	protected <T> boolean needsSorting(T[] array) {
		if ((array == null) || (array.length < 2)) {
			return false;
		}
		return true;
	}
	
	
	 protected  <T extends Comparable<T>> boolean isSortedAsc(T[] array)  {  
	    for (int i = 1; i < array.length; i++){
	      if (array[i].compareTo(array[i - 1]) < 0) {
	        return false;  
	      }
	    }
	    return true;  
	}  
	 
	 protected  <T extends Comparable<T>> boolean isSortedDesc(T[] array)  {  
	    for (int i = 1; i < array.length; i++){
	      if (array[i].compareTo(array[i - 1]) > 0) {
	        return false;  
	      }
	    }
	    return true;  
	}  
}
