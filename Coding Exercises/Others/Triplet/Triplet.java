import java.util.*;

public class Triplet{
  //finds all unique triplets in the array which gives the sum of zero
  private ArrayList<int[]> getUniqueTriplets(int [] array){
    if (array == null){
      return null;
    }
    
    Arrays.sort(array);
    
    //return null if all positive or if all negative
    if (array[0] > 0 || array[array.length-1] < 0){
      return null;
    }
    
    ArrayList<int[]> validTriplets = new ArrayList<int[]>();
    long sum = -1;
    
    //compute sums of all possible triplets and stop whenever sum crosses 0
    for (int i = 0; i < array.length && sum <= 0; i++){
      for (int j = 0; j < array.length && sum <= 0; j++){
        for (int k = 0; k < array.length && sum <= 0; k++){
          sum = array[i] + array[j] + array[k];
          if (sum == 0){
            int [] validTriplet = {array[i], array[j], array[k]};
            validTriplets.add(validTriplet);
          }
        }
      }
    }
    
    return validTriplets;
  }
}