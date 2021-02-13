package com.jhtp.chapter21.exo_21_10;

import com.jhtp.chapter21.datastructures.Stack;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author vannel
 */
public class ReverseSentenceTest {
   
   public ReverseSentenceTest() {
   }
   
   @BeforeEach
   public void setUp() {
   }
   
   @AfterEach
   public void tearDown() {
   }

   /**
    * Test of reverseSentence method, of class ReverseSentence.
    */
   @Test
   public void testReverseSentence() {
      String sentence1 = "This is how to reverse a sentence using a stack.";
      String sentence2 = "This@# ## is how to reverse__ a sentence ++using a stack.";
      Stack<String> expResult = new Stack<>();      
      expResult.push("This");
      expResult.push("is");
      expResult.push("how");
      expResult.push("to");
      expResult.push("reverse");
      expResult.push("a");
      expResult.push("sentence");
      expResult.push("using");
      expResult.push("a");
      expResult.push("stack");
      
      assertTrue(expResult.equals(ReverseSentence.reverseSentence(sentence1)));
      assertTrue(expResult.equals(ReverseSentence.reverseSentence(sentence2)));
   } 
   
}
