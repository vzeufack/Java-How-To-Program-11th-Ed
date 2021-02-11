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
   public void testInsert() {
      //insert into empty list
      SortedList testCase1List = new SortedList();
      testCase1List.insert(7);
      
      List<Integer> testCase1ExpResult = new List<>();
      testCase1ExpResult.insertAtBack(7);
      
      assertTrue(testCase1ExpResult.equals(testCase1List));
      
      //insert into non-empty list
      SortedList testCase2List = new SortedList ();
      testCase2List.insert(7);
      testCase2List.insert(-1);
      testCase2List.insert(10);
      testCase2List.insert(5);
      testCase2List.print();
      
      List<Integer> testCase2ExpResult = new List<>();
      testCase2ExpResult.insertAtBack(-1);
      testCase2ExpResult.insertAtBack(5);
      testCase2ExpResult.insertAtBack(7);
      testCase2ExpResult.insertAtBack(10);
      testCase2ExpResult.print();
      
      assertTrue(testCase2List.equals(testCase2ExpResult));
   }
}
