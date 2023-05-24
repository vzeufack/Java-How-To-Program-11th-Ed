import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SearchingAlgorithmsTest {
    @Test
    public void recursiveLinearSearchTest(){
       int[] array = {4, 2, 1, -6, 18, 0, -5, 8};
       assertEquals(5, SearchingAlgorithms.recursiveLinearSearch(array, 0, 0));
       assertEquals(0, SearchingAlgorithms.recursiveLinearSearch(array, 4, 0));
       assertEquals(7, SearchingAlgorithms.recursiveLinearSearch(array, 8, 0));
       assertEquals(3, SearchingAlgorithms.recursiveLinearSearch(array, -6, 2));
       assertEquals(-1, SearchingAlgorithms.recursiveLinearSearch(array, 100, 0));
    }

    @Test
    public void recursiveBinarySearchTest(){
        int[] array = {-6, -5, 0, 1, 2, 4, 8, 18};
        assertEquals(2, SearchingAlgorithms.recursiveBinarySearch(array, 0, 0, array.length - 1));
        assertEquals(0, SearchingAlgorithms.recursiveBinarySearch(array, -6, 0, array.length - 1));
        assertEquals(7, SearchingAlgorithms.recursiveBinarySearch(array, 18, 0, array.length - 1));
        assertEquals(3, SearchingAlgorithms.recursiveBinarySearch(array, 1, 2, array.length - 1));
        assertEquals(-1, SearchingAlgorithms.recursiveBinarySearch(array, 100, 0, array.length - 1));
    }
}
