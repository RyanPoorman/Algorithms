package poorman.algorithms.sorting;

public class CocktailSort extends ParentSorter{
	

	public void sort(Integer[] array ){
		if(!needsSorting(array))
			return;
		
	    boolean swapped;
	    do {

	      if (!(swapped = swapForward(array))) {
	          swapped = true;
	          break;
	        }
	      
	      swapBackward(array);
	    } while (swapped);
	  }

	private void swapBackward(Integer[] array) {
		for (int i = array.length - 2;i >= 0;i--) {
	        if (array[i] > array[i + 1]) {
	        	swap(array, i, i+1);
	        }
		}
	}

	private boolean swapForward(Integer[] array) {
		boolean swapped = false;
		for (int i = 0; i <= array.length - 2;i++) {
	        if (array[i] > array[i + 1]) {
	        	swap(array, i, i+1);
	        	swapped = true;
	        }
	      }
		return swapped;
	}
	 
}
