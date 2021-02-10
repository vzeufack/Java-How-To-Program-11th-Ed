package com.jhtp.chapter21.datastructures;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author vannel
 */
public class ListConcatenateTest {
   
   public ListConcatenateTest() {
   }
   
   @BeforeEach
   public void setUp() {
   }
   
   @AfterEach
   public void tearDown() {
   }

   /**
    * Test of concatenate method, of class ListConcatenate.
    */
   @Test
   public void testConcatenate() {
      //test two empty list
      List<Character> testCase1List1 = new List<>();
      List<Character> testCase1List2 = new List<>();
      List<Character> testCase1ExpResult = new List<>();
      ListConcatenate.concatenate(testCase1List1, testCase1List2);
      assertEquals(testCase1ExpResult, testCase1List1);
      
      
      //test with list1 empty
      List<Character> testCase2List1 = new List<>();
      
      List<Character> testCase2List2 = new List<>();
      testCase2List2.insertAtBack('a');
      
      List<Character> testCase2ExpResult = new List<>();
      testCase2ExpResult.insertAtBack('a');
      
      ListConcatenate.concatenate(testCase2List1, testCase2List2);      
      assertEquals(testCase2ExpResult, testCase2List1);
      
      
      //test with list2 empty
      List<Character> testCase3List1 = new List<>();
      testCase3List1.insertAtBack('a');
      
      List<Character> testCase3List2 = new List<>();
      
      List<Character> testCase3ExpResult = new List<>();
      testCase3ExpResult.insertAtBack('a');
      
      ListConcatenate.concatenate(testCase3List1, testCase3List2);
      assertEquals(testCase3ExpResult, testCase3List1);
      
      
      //test with non empty lists
      List<Character> testCase4List1 = new List<>();
      testCase4List1.insertAtBack('a');
      testCase4List1.insertAtBack('b');
      testCase4List1.insertAtBack('c');
      
      List<Character> testCase4List2 = new List<>();
      testCase4List2.insertAtBack('d');
      testCase4List2.insertAtBack('e');
      
      List<Character> testCase4ExpResult = new List<>();
      testCase4ExpResult.insertAtBack('a');
      testCase4ExpResult.insertAtBack('b');
      testCase4ExpResult.insertAtBack('c');
      testCase4ExpResult.insertAtBack('d');
      testCase4ExpResult.insertAtBack('e');
      
      ListConcatenate.concatenate(testCase4List1, testCase4List2);
      assertEquals(testCase4ExpResult, testCase4List1);
   }
}
