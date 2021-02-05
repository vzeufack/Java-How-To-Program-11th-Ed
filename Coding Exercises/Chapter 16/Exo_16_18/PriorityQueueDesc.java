import java.util.PriorityQueue;
import java.util.Comparator;

/**
  * PriorityQueueDesc.java
  * Orders elements in descending order in a priorityQueue
  */
public class PriorityQueueDesc {
   public static void main(String[] args) {
      // queue of capacity 11                             
      PriorityQueue<Double> queue = new PriorityQueue<>(Comparator.reverseOrder());

      // insert elements to queue
      queue.offer(3.2);          
      queue.offer(9.8);          
      queue.offer(5.4);
               
      System.out.println(queue);
      System.out.print("Polling from queue: ");

      // display elements in queue
      while (queue.size() > 0) {
         System.out.printf("%.1f ", queue.peek()); // view top element
         queue.poll(); // remove top element
      }
   } 
}
