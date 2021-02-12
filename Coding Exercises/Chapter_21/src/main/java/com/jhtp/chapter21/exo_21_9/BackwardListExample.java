package com.jhtp.chapter21.exo_21_9;

import com.jhtp.chapter21.datastructures.List;

/**
 *
 * @author vannel
 */
public class BackwardListExample {
   public static void main (String[] args){
      List<Character> list = new List<>();
      list.insertAtBack('a');
      list.insertAtBack('b');
      list.insertAtBack('c');
      list.print();
      
      List<Character> reversedCopy = List.reverseCopy(list);
      reversedCopy.print();
   }
}
