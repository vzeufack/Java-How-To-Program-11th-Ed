package com.jhtp.chapter21.exo_21_6;

import com.jhtp.chapter21.datastructures.List;
import java.util.NoSuchElementException;

/**
 * @author Vannel
 * @date 2/9/2021
 * Concatenates two linked lists of characters
 */
public class ListConcatenate{
   public static void main (String[] args){
      List<Character> list1 = new List<>("List 1");
      list1.insertAtBack('a');
      list1.insertAtBack('b');
      list1.insertAtBack('c');
      list1.print();
      
      List<Character> list2 = new List<>("List 2");
      list2.insertAtBack('d');
      list2.insertAtBack('e');
      list2.print();
      
      concatenate(list1, list2);
      System.out.println("After concatenation");
      list1.print();    
   }
   
   /**
    * Concatenates two linked lists of characters. 
    * The second list is appended to the first.
    * @param list1: List
    * @param list2: List
    */
   public static void concatenate(List<Character> list1, List<Character> list2){     
      if (!list1.isEmpty() || !list2.isEmpty()){
         if (list2.isEmpty()){}
         else{
            Character current = list2.removeFromFront();
            boolean hasElements = true;

            while (hasElements){
               list1.insertAtBack(current);
               try{
                  current = list2.removeFromFront();
               }
               catch(NoSuchElementException e){
                  hasElements = false;
               }
            }
         }
      }
   }
}
