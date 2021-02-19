package com.jhtp.chapter21.exo_21_13;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PostfixEvaluatorTest {
   @Test
   public void testEvaluatePostfixExpression(){
      StringBuffer[] testCases = {new StringBuffer("3 4 +"),
                                  new StringBuffer("6 2 + 5 * 8 4 / -"),
                                  new StringBuffer("65 2 + 52 * 86 43 / -"),
                                  new StringBuffer("32 5 + 9 12 * 4 / 4 2 ^ % -")};
      
      Integer[] expectedResults = {7, 38, 3482, 26};

      for (int i = 0; i < testCases.length; i++){
         assertEquals(expectedResults[i], PostfixEvaluator.evaluatePostfixExpression(testCases[i]));
      }
   }
}
