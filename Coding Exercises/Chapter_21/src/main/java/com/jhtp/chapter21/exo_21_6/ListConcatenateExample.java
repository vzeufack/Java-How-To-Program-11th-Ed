package com.jhtp.chapter21.exo_21_6;

import com.jhtp.chapter21.datastructures.List;
import com.jhtp.chapter21.datastructures.ListConcatenate;

/**
 * @author Vannel
 * @date 2/9/2021
 * Concatenates two linked lists of characters
 */
public class ListConcatenateExample{
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
      
      ListConcatenate.concatenate(list1, list2);
      System.out.println("After concatenation");
      list1.print();    
   }
}