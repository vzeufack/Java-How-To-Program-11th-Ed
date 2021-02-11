package com.jhtp.chapter21.exo_21_7;

import com.jhtp.chapter21.datastructures.SortedList;

/**
 *
 * @author vannel
 */
public class SortedListExample {
   public static void main(String[] args){
      SortedList list = new SortedList();
      list.insert(4);
      list.insert(-1);
      list.insert(10);
      list.insert(10);
      list.insert(0);
      list.print();
   }
}
