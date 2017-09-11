package poorman.algorithms.sorting;

import java.math.BigInteger;

public class InsertionSort extends ParentSorter implements Sortable {

	private <T extends Comparable<T>> T[] sort(T[] array, int first, int second) {
		if (!needsSorting(array)) {
			return array;
		}

		int length = array.length;
		int j;

		for (int i = 1; i < length; i++) {
			j = i;
			while ((j > 0) && (array[j - first].compareTo(array[j - second]) < 0)) {
				swap(array, j - first, j - second);
				j--;
			}
		}
		return array;
	}

	@Override
	public <T extends Comparable<T>> void sortAscendingInPlace(T[] values) {
		sort(values, 0, 1);
	}

	@Override
	public <T extends Comparable<T>> void sortDescendingInPlace(T[] values) {
		sort(values, 1, 0);
	}

	@Override
	public Double[] sort(Double[] values) {
		return sort(values, 0, 1);
	}

	@Override
	public Integer[] sort(Integer[] values) {
		return sort(values, 0, 1);
	}

	@Override
	public String[] sort(String[] values) {
		return sort(values, 0, 1);
	}

	@Override
	public BigInteger[] sort(BigInteger[] values) {
		return sort(values, 0, 1);
	}
}
