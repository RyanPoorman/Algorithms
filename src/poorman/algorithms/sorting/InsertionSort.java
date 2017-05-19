package poorman.algorithms.sorting;

public class InsertionSort extends ParentSort implements Sortable {

	public <T extends Comparable<T>> void sortAscending(T[] values) {
		sort(values, 0, 1);
	}

	public <T extends Comparable<T>> void sortDescending(T[] values) {
		sort(values, 1, 0);
	}

	private <T extends Comparable<T>> T[] sort(T[] array, int first, int second) {
		if (needsSorting(array)) {
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
}
