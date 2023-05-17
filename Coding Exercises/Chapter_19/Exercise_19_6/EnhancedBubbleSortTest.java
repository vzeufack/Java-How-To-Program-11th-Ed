package Exercise_19_6;
import Exercise_19_5.BubbleSort;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class EnhancedBubbleSortTest {
    @Test
    public void bubbleSortTest(){
        int[] array = {9, -4, 3, 1, 45, 10, 23, -100};
        EnhancedBubbleSort.sort(array);
        int[] sortedArray = {-100, -4, 1, 3, 9, 10, 23, 45};
        assertArrayEquals(sortedArray, array);
    }
}
