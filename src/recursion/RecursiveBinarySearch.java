package recursion;

public class RecursiveBinarySearch {

	public static int binarySearchRecursive(String[] array, String target, int low, int high) {
		if (array == null || target == null) {
			throw new IllegalArgumentException("Array or target cannot be null");
		}
		if (low > high) {
			return -1; // Target not found
		}

		int mid = low + (high - low) / 2;

		if (array[mid].equals(target)) {
			return mid;
		} else if (array[mid].compareTo(target) > 0) {
			return binarySearchRecursive(array, target, low, mid - 1);
		} else {
			return binarySearchRecursive(array, target, mid + 1, high);
		}
	}
}
