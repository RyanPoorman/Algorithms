package poorman.algorithms.sorting;

public class MergeSort extends ParentSorter {


	
	 public void sort(Integer[] array) {
    if (array.length > 1) {
    	Integer[] left = leftHalf(array);
    	Integer[] right = rightHalf(array);
 
      sort(left);
      sort(right);
 
      merge(array, left, right);
    }
  }
 
  public static Integer[] leftHalf(Integer[] array) {
    int size1 = array.length / 2;
    Integer[] left = new Integer[size1];
    for (int i = 0; i < size1; i++) {
      left[i] = array[i];
    }
    return left;
  }
 
  public static Integer[] rightHalf(Integer[] array) {
    int size1 = array.length / 2;
    int size2 = array.length - size1;
    Integer[] right = new Integer[size2];
    for (int i = 0; i < size2; i++) {
      right[i] = array[i + size1];
    }
    return right;
  }
 
 private void merge(Integer[] originalArray, Integer[] left, Integer[] right) {
    int i1 = 0;  
    int i2 = 0; 
 
    for (int i = 0; i < originalArray.length; i++) {
      if (i2 >= right.length || (i1 < left.length && left[i1] <= right[i2])) {
    	  originalArray[i] = left[i1]; 
        i1++;
      } else {
    	  originalArray[i] = right[i2]; 
        i2++;
      }
    }
  }
}
