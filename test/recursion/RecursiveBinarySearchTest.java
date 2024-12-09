package recursion;

import org.junit.Test;
import static org.junit.Assert.*;

public class RecursiveBinarySearchTest {

    @Test
    public void testStringBinarySearch() {
        String[] words = {"apple", "banana", "cherry", "date", "elderberry"};
        assertEquals(2, RecursiveBinarySearch.binarySearchRecursive(words, "cherry", 0, words.length - 1));
        assertEquals(-1, RecursiveBinarySearch.binarySearchRecursive(words, "fig", 0, words.length - 1));
        assertEquals(0, RecursiveBinarySearch.binarySearchRecursive(words, "apple", 0, words.length - 1));
    }
    
    @Test(expected = IllegalArgumentException.class)
	public void testNullArray() {
	    RecursiveBinarySearch.binarySearchRecursive(null, null, 0, 0);
	}

}
