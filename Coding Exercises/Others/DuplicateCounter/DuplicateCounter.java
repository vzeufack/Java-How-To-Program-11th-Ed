import java.util.HashMap;
import java.util.Iterator;
import java.util.Arrays;

public class DuplicateCounter{
  public static void main (String [] args){
    int [] a = {2,4,5,5,2,2,3,5,6,6}; //3 duplicate
    System.out.println(countDuplicate1(a));
    System.out.println(countDuplicate2(a));
    
    int [] b = {2,4,32,23,4,32,2,2,45,23,4,5,5}; //5 duplicate
    System.out.println(countDuplicate1(b));
    System.out.println(countDuplicate2(b));
  }
  
  public static int countDuplicate1(int [] input){
    if (input == null || input.length == 0)
      return 0;
    
    //create a hashmap
    HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
    
    //store every number's count in it
    for (int i = 0; i < input.length; i++){
      if (hmap.get(input[i]) == null)
        hmap.put(input[i], 1);
      else
        hmap.put(input[i], hmap.get(input[i]) + 1);
    }
    
    //count all the numbers with a count higher than 1
    Iterator iter = hmap.keySet().iterator();
    int count = 0;
        
    while (iter.hasNext())
    {
      if(hmap.get(iter.next()) > 1)
        count++;
    }    
    
    return count;
  }
  
  public static int countDuplicate2(int [] input){
    if (input == null || input.length == 0)
      return 0;
      
    //sort the array
    int [] inputCopy = new int [input.length];
    System.arraycopy(input, 0, inputCopy, 0, input.length);
    Arrays.sort(inputCopy);
    
    //count whenever we find the first duplicate of each number
    int count = 0;
    boolean countFlag = true;
    int temp = inputCopy[0];
    
    for (int i = 1; i < inputCopy.length; i++){
      if (inputCopy[i] == temp){
        if (countFlag){
          count++;
          countFlag = false;
        }
        else{}
      }
      else{
        temp = inputCopy[i];
        countFlag = true;
      }
    }
    return count;
  }
}

/**
 I would choose the first approach (CountDuplicate1) because it solves the problem in constant time O(n+m) where n is the input size and m is the number of unique values in the array. The second approach solves the problem in O(nlogn + n) where O(nlogn) represents the running time for sorting and O(n) is the running time for the following for loop.
 **/