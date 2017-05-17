package poorman.algorithms.sorting;

public interface Sortable {
	<T extends Comparable<T>> void sortAscending(T[] values);
	<T extends Comparable<T>> void sortDescending(T[] values);
}
