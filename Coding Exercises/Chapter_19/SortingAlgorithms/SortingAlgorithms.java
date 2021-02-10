import java.security.SecureRandom;
import java.util.Arrays;
import java.util.ArrayList;

/**
  * Implementation and test of sorting algorithms
  */
public class SortingAlgorithms{
  /**
    * Tests sorting algorithms.
    */
  public static void main (String[] args){
    SecureRandom generator = new SecureRandom();
    int[] data = generator.ints(10, 0, 100).toArray();
    System.out.println(Arrays.toString(data));
    selectionSort(data);
    //insertionSort(data);
    //mergeSort(data);
    System.out.println(Arrays.toString(data));
  }
  
  /**
    * Sorts a given integer array using selection sort.
    *
    * @param data: int[].
    *  <p> the integer array to sort.
    */
  public static void selectionSort(int[] data){ 
    for (int i = 0; i < data.length-1; i++){
      //find smallest element in range i to end
      int idxOfSmallest = i;
      for (int k = i+1; k < data.length; k++){
        if (data[k] < data[idxOfSmallest])
          idxOfSmallest = k;
      }
      
      //swap smallest and data[i]
      int temp = data[i];
      data[i] = data[idxOfSmallest];
      data[idxOfSmallest] = temp;
    }
  }
  
  /**
    * Sorts a given integer array using insertion sort.
    *
    * @param data: int[].
    *   <p> the integer array to sort.
    */
    public static void insertionSort(int[] data){
    for (int i = 1; i < data.length; i++){
      int current = data[i];
      int k = i-1;
      
      //finding correct position of element i in data[0 .. i-1]
      while (k >= 0 && data[k] > current){
        data[k+1] = data[k];
        k--;
      }
      
      //inserting current element at right position
      data[k+1] = current;
    }
  }
  
  /**
    * Sorts a given integer array using merge sort.
    *
    * @param data: int[].
    *   <p> the integer array to sort.
    */
    public static void mergeSort(int[] data){
    //sorts the array over its full length
    sortArray(data, 0, data.length - 1);
  }
  
  /**
    * Recursively sorts a given integer array.
    *
    * @param data: int[].
    *   <p> The integer array to sort.
    *
    * @param startIdx: int.
    *   <p> The start index of the subarray to sort.
    *
    * @param lastIdx: int.
    *   <p> The last index of the subarray to sort.
    */
  private static void sortArray(int[] data, int startIdx, int lastIdx){
    if (lastIdx - startIdx >= 1){
       //divide in two almost equal parts
       int middle = (startIdx + lastIdx)/2;
       //sort left
       sortArray(data, startIdx, middle);
       //sort right
       sortArray(data, middle + 1, lastIdx);
       //merge left and right
       merge(data, startIdx, middle, middle + 1, lastIdx);
    }
  }
  
  /**
    * Merges two sorted arrays of integer
    *
    * @param data: int[]
    *   <p> The integer array from which to extract the subarrays to sort.
    *
    * @param startIdx1: int
    *   The start index of the first subarray
    *
    * @param lastIdx1: int
    *   The last index of the first subarray
    *
    * @param startIdx2: int
    *   The start index of the second subarray
    *
    * @param lastIdx2: int
    *   The last index of the second subarray
    */
   private static void merge(int[] data, int startIdx1, int lastIdx1, int startIdx2, int lastIdx2){
     int i = startIdx1;
     int j = startIdx2;
     ArrayList<Integer> mergedArray = new ArrayList<Integer>();
     
     //incrementally add smallest element from any of the two subarrays
     while (i <= lastIdx1  && j <= lastIdx2 ){
       if (data[i] < data[j]){
         mergedArray.add(data[i]);
         i++;
       }
       else{
         mergedArray.add(data[j]);
         j++;
       }
     }
     
     //if there were remaining elements from subarray1, then add them
     if (i <= lastIdx1){
       for (int k = i; k <= lastIdx1; k++){
         mergedArray.add(data[k]);
       } 
     }
     
     //if there were remaining elements from subarray2, then add them
     if (j <= lastIdx2){
       for (int k = j; k <= lastIdx2; k++){
         mergedArray.add(data[k]);
       } 
     }
     
     //copy back mergedArray into original array
     for (int k = 0; k < mergedArray.size(); k++){
       data[startIdx1 + k] = mergedArray.get(k);
     }
   }
}