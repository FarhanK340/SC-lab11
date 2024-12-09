package recursion;

import org.junit.Test;
import static org.junit.Assert.*;

public class RecursiveBinarySearchTest{

	// Testcases for Integer Binary Search
	@Test
	public void testIntegerBinarySearch() {
	    int[] array = {1, 3, 5, 7, 9, 11};
	    assertEquals(3, RecursiveBinarySearch.binarySearchRecursive(array, 7));
	    assertEquals(-1, RecursiveBinarySearch.binarySearchRecursive(array, 4));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNullArray() {
	    RecursiveBinarySearch.binarySearchRecursive(null, 5);
	}


}