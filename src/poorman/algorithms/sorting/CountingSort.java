package poorman.algorithms.sorting;

public class CountingSort extends ParentSort implements Sortable {

	@Override
	public <T extends Comparable<T>> void sortAscending(T[] values) {
		sort(values, 0);
	}

	@Override
	public <T extends Comparable<T>> void sortDescending(T[] values) {
		sort(values, 1);
	}

	  private <T extends Comparable<T>> void sort(T[] values, int orderType) {
		    if (!(values instanceof Integer[])) {
		      System.out.println("Only Integer arrays can be sorted by the Counting Sort algorithm.");
		    } else {
		      // If the array is null or has the size of 1, it means it is already sorted.
		      if ((null == values) || (values.length < 2)) {
		        return;
		      }

		      Integer[] temp = (Integer[]) values;
		      int count = 0;
		      int indexToInsertElement = 0;

		      RangeElements rangeElements = Utils.getLowestAndHighestElement(temp);
		      // The above method will iterate over all the elements in the array.
		      count += temp.length;

		      int lowestElement = rangeElements.getLowestElement();
		      int highestElement = rangeElements.getHighestElement();
		      // (highestElement - lowestElement) + 1 => It will be the possible range of the elements.
		      int[] occurrences = new int[(highestElement - lowestElement) + 1];

		      // Iterate through the array and count how many times each value has appeared and increment by
		      // 1 every time.
		      for (int i = 0; i < values.length; i++) {
		        occurrences[temp[i] - lowestElement] += 1;
		        count++;
		      }

		      // This peace of code is necessary just because we only want to create one method that will
		      // sort ascending and descending, otherwise this code could be deleted.
		      int currentIndex = 0;
		      int finishIndex = 0;
		      int increment = 0;
		      if (0 == orderType) {
		        // Ascending.
		        currentIndex = 0;
		        finishIndex = occurrences.length;
		        increment = 1;
		      } else if (1 == orderType) {
		        // Descending.
		        currentIndex = occurrences.length - 1;
		        finishIndex = -1;
		        increment = -1;
		      }

		      while (currentIndex != finishIndex) {
		        int nrOccurrences = occurrences[currentIndex];
		        count++;

		        for (int j = 0; j < nrOccurrences; j++) {
		          // It is necessary to "+ lowestElement" to compensate when it was subtracted.
		          temp[indexToInsertElement++] = currentIndex + lowestElement;
		          count++;
		        }

		        currentIndex += increment;
		      }

		      System.out.printf("%2s: ", count);
		    }
		  }
		}
}
