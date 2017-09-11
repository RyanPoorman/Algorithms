package poorman.algorithms.sorting;

import java.math.BigInteger;

public interface Sortable {
	<T extends Comparable<T>> void sortAscendingInPlace(T[] values);
	<T extends Comparable<T>> void sortDescendingInPlace(T[] values);

	Double[] sort(Double[] values);
	Integer[] sort(Integer[] values);
	String[] sort(String[] values);
	BigInteger[] sort(BigInteger[] values);
}
