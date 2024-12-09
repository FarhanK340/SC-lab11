package recursion;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class RecursiveBinarySearchTest {

    @Test
    public void testFindAllIndices() {
        int[] numbers = {1, 2, 2, 3, 4, 5, 5, 5, 6};
        List<Integer> indices = RecursiveBinarySearch.findAllIndices(numbers, 5, 0, numbers.length - 1);
        assertEquals(List.of(5, 6, 7), indices);

        indices = RecursiveBinarySearch.findAllIndices(numbers, 10, 0, numbers.length - 1);
        assertTrue(indices.isEmpty());
    }
    
    @Test(expected = IllegalArgumentException.class)
	public void testNullArray() {
	    RecursiveBinarySearch.findAllIndices(null, 0, 0, 0);
	}

}
