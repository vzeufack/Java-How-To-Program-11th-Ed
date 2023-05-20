import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortingAlgorithmsTest {

    int[] array, array2, array3;
    int[] sortedArray = {1, 3, 4, 9, 10, 23, 45, 100};
    int[] sortedArray2 = {10};
    int[] sortedArray3 = {-6, -5, 0, 1, 2, 4, 8, 8};

    @BeforeEach
    void setUp() throws Exception{
        array = new int[]{9, 4, 3, 1, 45, 10, 23, 100};
        array2 = new int[]{10};
        array3 = new int[]{4, 2, 1, -6, 8, 0, -5, 8};
    }

    @Test
    public void bucketSortTest(){
        SortingAlgorithms.bucketSort(array);
        assertArrayEquals(sortedArray, array);
        SortingAlgorithms.bucketSort(array2);
        assertArrayEquals(sortedArray2, array2);
    }

    @Test
    public void bubbleSortTest(){
        SortingAlgorithms.bubbleSort(array);
        assertArrayEquals(sortedArray, array);
        SortingAlgorithms.bubbleSort(array2);
        assertArrayEquals(sortedArray2, array2);
        SortingAlgorithms.bubbleSort(array3);
        assertArrayEquals(sortedArray3, array3);
    }

    @Test
    public void enhancedBubbleSortTest(){
        SortingAlgorithms.enhancedBubbleSort(array);
        assertArrayEquals(sortedArray, array);
        SortingAlgorithms.enhancedBubbleSort(array2);
        assertArrayEquals(sortedArray2, array2);
        SortingAlgorithms.enhancedBubbleSort(array3);
        assertArrayEquals(sortedArray3, array3);
    }
}
