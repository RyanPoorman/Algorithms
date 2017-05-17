package poorman.algorithms.sorting;

public class BubbleSort extends ParentSort implements Sortable  {

	public <T extends Comparable<T>> void sortAscending(T[] values) {
		sort(values, 0, 1);
	}

	@Override
	public <T extends Comparable<T>> void sortDescending(T[] values) {
		sort(values, 1, 0);
	}

	private <T extends Comparable<T>> T[] sort(T[] array, int first, int second) {
		int arrayLength = array.length;

		for (int i = 1; i < arrayLength; i++) {
			for (int j = 0; j < arrayLength - i; j++) {
				
				if (array[j + first].compareTo(array[j + second]) > 0) {
					swap(array, j + first, j + second);
				}
			}
		}
		
		return array;
	}

}
