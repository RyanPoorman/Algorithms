package poorman.algorithms.sorting;

import java.math.BigInteger;

public class CocktailSort extends ParentSorter implements Sortable {

	private <T extends Comparable<T>> T[] sort(T[] array, int first, int second) {

		if (!needsSorting(array)) {
			return array;
		}

		boolean swapped = true;
		int start = 0;
		int end = array.length;

		while (swapped == true) {
			swapped = false;

			for (int i = 1; i < end; i++) {
				for (int j = 0; j < end - i; j++) {

					if (array[j + first].compareTo(array[j + second]) > 0) {
						swap(array, j + first, j + second);
						swapped = true;
					}
				}
			}

			if (swapped == false)
				break;

			swapped = false;
			end = end - 1;

			for (int i = end - 1; i >= start; i--) {
				if (array[i + first].compareTo(array[i + second]) > 0) {

					swap(array, i + first, i + second);
					swapped = true;

				}

				start = start + 1;
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
