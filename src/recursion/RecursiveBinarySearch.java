package recursion;

public class RecursiveBinarySearch {

    public static int binarySearchRecursive(int[] array, int target) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null.");
        }
        if (array.length == 0) {
            return -1; // Empty array case
        }
        return binarySearchRecursive(array, target, 0, array.length - 1);
    }

    // Recursive helper function
    private static int binarySearchRecursive(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1; // Base case: range is empty
        }

        int mid = left + (right - left) / 2;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            return binarySearchRecursive(array, target, left, mid - 1);
        } else {
            return binarySearchRecursive(array, target, mid + 1, right);
        }
    }

}
