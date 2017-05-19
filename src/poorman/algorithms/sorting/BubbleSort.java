package poorman.algorithms.sorting;

public class BubbleSort extends ParentSort implements Sortable {

	@Override
	public <T extends Comparable<T>> void sortAscending(T[] values) {
		sort(values, 0, 1);
	}

	@Override
	public <T extends Comparable<T>> void sortDescending(T[] values) {
		sort(values, 1, 0);
	}

	private <T extends Comparable<T>> T[] sort(T[] array, int first, int second) {

		if (needsSorting(array)) {
			return array;
		}

		int length = array.length;

		for (int i = 1; i < length; i++) {
			for (int j = 0; j < length - i; j++) {

				if (array[j + first].compareTo(array[j + second]) > 0) {
					swap(array, j + first, j + second);
				}
			}
		}

		return array;

	}

}
