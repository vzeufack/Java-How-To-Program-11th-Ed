// Queue uses class List.
package com.jhtp.chapter21.datastructures;

import java.util.NoSuchElementException;

public class Queue<E> {
   private List<E> queueList;

   // constructor
   public Queue() {queueList = new List<E>("queue");}

   // add object to queue
   public void enqueue(E object) {queueList.insertAtBack(object);}

   // remove object from queue
   public E dequeue() throws NoSuchElementException {
      return queueList.removeFromFront(); 
   } 

   // determine if queue is empty
   public boolean isEmpty() {return queueList.isEmpty();}
   
   //determine the number of items in the queue
   public int size(){
      return queueList.size();
   }

   // output queue contents
   public void print() {queueList.print();}
}
