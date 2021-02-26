package com.jhtp.chapter21.datastructures;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author vannel
 */
public class ListTest {
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

   @Test
   public void testSize(){
      List<Integer> list = new List<>();
      assertEquals(0, list.size());

      for (int i = 0; i < 10; i++)
         list.insertAtBack(i);
      assertEquals(10, list.size());

      list.removeFromBack();
      assertEquals(9, list.size());
   }
}
