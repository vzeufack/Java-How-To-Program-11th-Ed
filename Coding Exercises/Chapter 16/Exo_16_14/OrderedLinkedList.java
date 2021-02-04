import java.util.LinkedList;
import java.security.SecureRandom;
import java.util.Arrays;

/**
  * OrderedLinkedList.java by Vannel 2/3/2021
  * Inserts elements in a linkedList in sorted order
  * Computes the sum and average of the linkedList elements
  */
public class OrderedLinkedList{
   public static void main (String[] args){
      SecureRandom generator = new SecureRandom();
      
      Integer[] data = new Integer[25];
      for (int i = 0; i < data.length; i++){
         data[i] = generator.nextInt(101);
      }
      
      LinkedList<Integer> sortedList = buildSortedLinkedList(data);
      
      System.out.printf("Original List: %s%n", Arrays.asList(data));
      System.out.printf("Sorted List: %s%n", sortedList);
      System.out.printf("Sum = %d%n", sum(sortedList));
      System.out.printf("Average = %f%n", average(sortedList));
   }
   
   /**
     * Inserts elements from an Integer array into LinkedList in sorted order
     * and returns the sorted list.
     *
     * @param unsortedArray: Integer[].
     *    The array from which the elements are inserted into the LinkedList.
     *
     * @return sortedList: LinkedList<Integer>
     *    The sorted linkedList of integers.
     */
    public static LinkedList<Integer> buildSortedLinkedList(Integer[] unsortedArray){
       LinkedList<Integer> sortedList = new LinkedList<>();
       
       for (Integer element: unsortedArray){
          if (element != null){
             if (sortedList.size() == 0)
                sortedList.add(element);
             else{
                int idx = 0;
                while (idx < sortedList.size() && sortedList.get(idx) < element){
                   idx++;
                }
                sortedList.add(idx, element);
             }
          }
       }
       return sortedList;
    }
    
    /**
      * Sums all the elements in a LinkedList
      *
      * @param list: LinkedList<Integer>
      *    The list of elements to sum.
      *
      * @param sum: Long.
      *    The sum of elements.
      */
    public static Long sum(LinkedList<Integer> list){
       if (list.isEmpty())
          return null;
          
       Long sum = 0L;
       for (Integer element: list){
          sum += element;
       }
       return sum;
    }
    
    /**
      * computes the average of all the elements in a LinkedList
      *
      * @param list: LinkedList<Integer>
      *    The list of elements.
      *
      * @param average: Float.
      *    The average of the elements in the list.
      */
    public static Float average(LinkedList<Integer> list){
       if (list.isEmpty())
          return null;
       
       return sum(list)/(float)list.size();
    }
}