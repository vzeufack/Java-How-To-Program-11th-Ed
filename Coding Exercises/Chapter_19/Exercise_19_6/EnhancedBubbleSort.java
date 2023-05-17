package Exercise_19_6;

import java.util.Arrays;

public class EnhancedBubbleSort {
    public static void main(String[] args) {
        int[] test = {3,4,1,2,5};
        sort(test);
        System.out.println(Arrays.toString(test));
    }
    public static void sort(int[] array){
        boolean isSorted = false;

        for(int i = 0; i < array.length-1 && !isSorted; i++){
            isSorted = true;
            for(int j = 0; j < array.length-1-i; j++) {
                if (array[j] > array[j + 1]) {
                    isSorted = false;
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
}
