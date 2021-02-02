import java.util.Arrays;
import java.util.ArrayList;

public class ArrayIntersection{
  public static void main (String[] args){
    int[] array1 = {8,8,5,3,5,7,5,7,7,7,23};
    int[] array2 = {7,7,10,3,5,3,3,11};
    Integer [] result = getIntersection(array1, array2);
    for (int i = 0; i < result.length; i++){
      System.out.println(result[i]);
    }
  }
  
  /**
  * Returns the intersection of two integer arrays
  *
  * @array1: int[]
  *   The first array
  *
  * @array2: int[]
  *   The second array
  *
  * @return intersection: int[]
  */
  private static Integer[] getIntersection(int[] array1, int[] array2){
   //making copies of the input arrays just in case it is not allowed to modify the input
   int[] array1Copy = new int[array1.length];
   System.arraycopy(array1, 0, array1Copy, 0, array1.length);
   int[] array2Copy = new int[array2.length];
   System.arraycopy(array2, 0, array2Copy, 0, array2.length);
 
   //sort and remove duplicates from input arrays
   int[] cleanArray1 = sortAndRemoveDuplicates(array1Copy);
   int[] cleanArray2 = sortAndRemoveDuplicates(array2Copy);

   //determine smallest array
   int[] smallest = cleanArray1;
   int[] longest = cleanArray2;
   if (cleanArray1.length > cleanArray2.length){
     smallest = cleanArray2;
     longest = cleanArray1;
   }

   //binary search every element from smallest into longest
   //if present, add to result
   ArrayList<Integer> intersection = new ArrayList<Integer>();
   for (int i = 0; i < smallest.length; i++){
     if (Arrays.binarySearch(longest, smallest[i]) >= 0){
       intersection.add(smallest[i]);
     }
   }

   Integer[] result = new Integer[intersection.size()];
   result = intersection.toArray(result);
   return result;
 }

  /**
    * sorts and remove duplicates from an integer array
    *
    * @inputArray: int[]
    *   The input array
    *
    * @return the sorted array without duplicates
    */
  private static int[] sortAndRemoveDuplicates(int[] inputArray){
    //sort
    Arrays.sort(inputArray);
    
    int temp = inputArray[0];
    int i = 1;
    int j = 1;
    
    //remove duplicates in place
    while (j < inputArray.length){
      //if repeated value is found, increment j
      if (inputArray[j] == temp){
        j++;
      }
      //if new value is found, insert the value at i and increment i and j
      else{
        temp = inputArray[j];
        inputArray[i] = inputArray[j];
        i++;
        j++;
      }
    }
    
    //return only elements from 0 to i    
    int[] result = new int[i];
    System.arraycopy(inputArray, 0, result, 0, i);
    return result;
  }
}