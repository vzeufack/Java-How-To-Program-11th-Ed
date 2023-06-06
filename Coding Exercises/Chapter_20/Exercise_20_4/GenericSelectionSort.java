package Exercise_20_4;

import java.security.SecureRandom;
import java.util.Arrays;

public class GenericSelectionSort {
    // sort array using selection sort
    public static <T extends Comparable> void selectionSort(T[] data) {
        // loop over data.length - 1 elements
        for (int i = 0; i < data.length - 1; i++) {
            int smallest = i; // first index of remaining array

            // loop to find index of smallest element
            for (int index = i + 1; index < data.length; index++) {
                if(data[index].compareTo(data[smallest]) < 0){
                    smallest = index;
                }
            }

            swap(data, i, smallest); // swap smallest element into position
        }
    }

    // helper method to swap values in two elements
    private static <T> void swap(T[] data, int first, int second) {
        T temporary = data[first]; // store first in temporary
        data[first] = data[second]; // replace first with second
        data[second] = temporary; // put temporary in second
    }

    public static void main(String[] args) {
        SecureRandom generator = new SecureRandom();

        Integer[] data = generator.ints(10, 10, 91).boxed().toArray(Integer[]::new);
        System.out.printf("Unsorted array: %s%n", Arrays.toString(data));
        selectionSort(data); // sort array
        System.out.printf("Sorted array: %s%n", Arrays.toString(data));

        Float[] data2 = {1f, -5.2f, 7f, 15f, -25f};
        System.out.printf("Unsorted array: %s%n", Arrays.toString(data2));
        selectionSort(data2); // sort array
        System.out.printf("Sorted array: %s%n", Arrays.toString(data2));
    }
}
