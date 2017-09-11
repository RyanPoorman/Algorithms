package poorman.algorithms.sorting;

import java.math.BigInteger;

public class BucketSort extends ParentSorter implements Sortable{
	int maxValue = 0;
	
	public BucketSort(int maxVal) {
		maxValue = maxVal;
	}
	
	private <T extends Comparable<T>> T[] sort(T[] values, boolean sortAscending) {
		 if (!needsSorting(values)) {
	          return values;
	     }

		 Integer[] bucket = new Integer[maxValue+1];
		 initializeBucket(maxValue, bucket, values);
	    
	     
		 if(sortAscending) 
			 sortBucketsAscending(maxValue, bucket, values);
		 else 
			 sortBucketsDescending(maxValue, bucket, values);
		
		 return values;
	}

	
	private <T extends Comparable<T>> void sortBucketsAscending(int maxValue, Integer[] bucket, T[] values) {
	      int outPos = 0;
	      for (Integer i = 0;  i <bucket.length; i++) {
	         for (int j = 0; j < bucket[i]; j++) {
	            values[outPos++] = (T)i;
	         }
	      }
	}
	
	private <T extends Comparable<T>> void sortBucketsDescending(int maxValue, Integer[] bucket, T[] values) {
	  int outPos = values.length-1;
      for (Integer i = 0; i < bucket.length; i++) {
         for (int j = 0; j < bucket[i]; j++) {
            values[outPos--]=(T)i;
         }
      }
	}


	private <T extends Comparable<T>>void initializeBucket(int maxValue, Integer[] bucket, T[] values) {
	  
		for (int i = 0; i < bucket.length; i++) {
			bucket[i] = 0;
		}
 
		for (Integer i = 0; i < values.length; i++) {
			int x = ((Integer) values[i]).intValue();
			
			bucket[x]++;
		}
	
	}

	@Override
	public <T extends Comparable<T>> void sortAscendingInPlace(T[] values) {
		sort(values, true);
	}

	@Override
	public <T extends Comparable<T>> void sortDescendingInPlace(T[] values) {
		sort(values, false);
	}

	@Override
	public Double[] sort(Double[] values) {
		return sort(values, true);
	}

	@Override
	public Integer[] sort(Integer[] values) {
		return sort(values, true);
	}

	@Override
	public String[] sort(String[] values) {
		return sort(values, true);
	}

	@Override
	public BigInteger[] sort(BigInteger[] values) {
		return sort(values, true);
	}
}
