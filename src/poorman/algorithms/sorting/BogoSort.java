package poorman.algorithms.sorting;

import java.math.BigInteger;
import java.util.Random;

public class BogoSort extends ParentSorter implements Sortable{

	private Random generator = new Random();
	
	private <T extends Comparable<T>> T[] runSort(T[] values) {
		
		if(!needsSorting(values))
			return values;
		
		for (int i = 0; i < values.length; i++){  
	        int randomPosition = generator.nextInt(values.length);  
	        swap(values, i, randomPosition);
	      }
		
		return values;  
	}

	@Override
	public <T extends Comparable<T>> void sortAscendingInPlace(T[] values) {
		while(!isSortedAsc(values)) {
			runSort(values);
		};
	}

	@Override
	public <T extends Comparable<T>> void sortDescendingInPlace(T[] values) {
		while(!isSortedDesc(values)) {
			runSort(values);
		};
	}


	@Override
	public Double[] sort(Double[] values) {
		while(!isSortedAsc(values)) {
			runSort(values);
		};
		
		return values;
	}


	@Override
	public Integer[] sort(Integer[] values) {
		while(!isSortedAsc(values)) {
			runSort(values);
		};
		
		return values;
	}


	@Override
	public String[] sort(String[] values) {
		while(!isSortedAsc(values)) {
			runSort(values);
		};
		
		return values;
	}
	

	@Override
	public BigInteger[] sort(BigInteger[] values) {
		while(!isSortedAsc(values)) {
			runSort(values);
		};
		
		return values;
	}

}
