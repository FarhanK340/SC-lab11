package recursion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecursiveBinarySearch {

    public static List<Integer> findAllIndices(int[] array, int target, int low, int high) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        List<Integer> indices = new ArrayList<>();
        findAllIndicesHelper(array, target, low, high, indices);
        Collections.sort(indices);
        return indices;
    }

    private static void findAllIndicesHelper(int[] array, int target, int low, int high, List<Integer> indices) {
        if (low > high) {
            return;
        }

        int mid = low + (high - low) / 2;

        if (array[mid] == target) {
            // Add the current index
            indices.add(mid);

            // Search both left and right for other occurrences
            findAllIndicesHelper(array, target, low, mid - 1, indices);
            findAllIndicesHelper(array, target, mid + 1, high, indices);
        } else if (array[mid] > target) {
            findAllIndicesHelper(array, target, low, mid - 1, indices);
        } else {
            findAllIndicesHelper(array, target, mid + 1, high, indices);
        }
    }
}

