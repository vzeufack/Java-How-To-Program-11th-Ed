package com.jhtp.chapter21.datastructures;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author vannel
 */
public class ListTest {
   
   public ListTest() {
   }
   
   @BeforeEach
   public void setUp() {
   }
   
   @AfterEach
   public void tearDown() {
   }

   /**
    * Test of reverseCopy of empty list.
    */
   @Test
   public void testReverseCopyEmptyList() {
      List<Integer> list = new List<>();
      List<Integer> reversedList = List.reverseCopy(list);
      List<Integer> expResult = new List<>();
      assertTrue(expResult.equals(reversedList));      
   }   
   
   @Test
   public void testReverseCopyNonEmptyList(){
      List<Integer> list = new List<>();
      for (int i = 0; i < 10; i++)
         list.insertAtBack(i);
      
      List<Integer> reversedCopy = List.reverseCopy(list);
      
      List<Integer> expResult = new List<>();
      for (int i = 9; i >= 0; i--)
         expResult.insertAtBack(i);
      
      assertTrue(expResult.equals(reversedCopy));
   }
}
