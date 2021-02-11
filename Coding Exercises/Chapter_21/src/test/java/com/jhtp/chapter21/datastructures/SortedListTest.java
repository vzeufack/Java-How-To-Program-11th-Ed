package com.jhtp.chapter21.datastructures;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author vannel
 */
public class SortedListTest {   
   @BeforeEach
   public void setUp() {
   }
   
   @AfterEach
   public void tearDown() {
   }

   @Test
   public void testInsertIntoEmtpyList() {
      SortedList list = new SortedList();
      list.insert(7);
      
      List<Integer> expResult = new List<>();
      expResult.insertAtBack(7);
      
      assertTrue(expResult.equals(list));      
   }
   
   @Test
   public void testInsertIntoNonEmtpyList(){
      SortedList list = new SortedList ();
      list.insert(7);
      list.insert(-1);
      list.insert(10);
      list.insert(5);
      
      List<Integer> expResult = new List<>();
      expResult.insertAtBack(-1);
      expResult.insertAtBack(5);
      expResult.insertAtBack(7);
      expResult.insertAtBack(10);
      
      assertTrue(expResult.equals(list));
   }
   
   @Test
   public void testMergeEmptyLists(){
      SortedList list1 = new SortedList();
      SortedList list2 = new SortedList();
      list1.merge(list2);
      List expResult = new List();
      assertTrue(expResult.equals(list1));
   }
   
   @Test
   public void testMergeNonEmptyAndEmptyLists(){
      SortedList list1 = new SortedList();
      list1.insert(2);
      list1.insert(1);
      list1.insert(3);
      
      SortedList list2 = new SortedList();
      
      list1.merge(list2);
      
      List expResult = new List();
      expResult.insertAtBack(1);
      expResult.insertAtBack(2);
      expResult.insertAtBack(3);
      
      assertTrue(expResult.equals(list1));
   }
   
   @Test
   public void testMergeEmptyAndNonEmptyLists(){
      SortedList list1 = new SortedList();
      SortedList list2 = new SortedList();
      list2.insert(2);
      list2.insert(1);
      list2.insert(3);
      
      list1.merge(list2);
      
      List expResult = new List();
      expResult.insertAtBack(1);
      expResult.insertAtBack(2);
      expResult.insertAtBack(3);
      
      assertTrue(expResult.equals(list1));
   }
   
   @Test
   public void testMergeNonEmptyLists(){
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
      
      List expResult = new List();
      expResult.insertAtBack(1);
      expResult.insertAtBack(2);
      expResult.insertAtBack(3);
      expResult.insertAtBack(4);
      expResult.insertAtBack(5);
      expResult.insertAtBack(6);
      expResult.insertAtBack(7);
      
      assertTrue(expResult.equals(list1));
   }
}
