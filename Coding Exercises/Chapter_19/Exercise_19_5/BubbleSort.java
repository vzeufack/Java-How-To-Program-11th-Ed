package Exercise_19_5;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] test = {5,4,3,2,1};
        sort(test);
        System.out.println(Arrays.toString(test));
    }
    public static void sort(int[] array){
        for(int i = 0; i < array.length-1; i++){
            for(int j = 0; j < array.length-1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
}
