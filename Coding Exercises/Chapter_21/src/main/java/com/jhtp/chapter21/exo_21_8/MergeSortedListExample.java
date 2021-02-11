package com.jhtp.chapter21.exo_21_8;

import com.jhtp.chapter21.datastructures.SortedList;

/**
 * Example of merging two sorted lists.
 * @author vannel
 */
public class MergeSortedListExample {
   public static void main (String[] args){
      SortedList list1 = new SortedList();
      list1.insert(2);
      list1.insert(1);
      list1.insert(3);
      
      SortedList list2 = new SortedList();
      list2.insert(6);
      list2.insert(5);
      list2.insert(4);
      list2.insert(7);
      
      list1.merge(list2);
      list1.print();
   }
}
