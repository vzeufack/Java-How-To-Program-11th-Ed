package com.jhtp.chapter21.exo_21_12;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InfixToPostfixConverterTest {
   @Test
   public void testConvertSingleDigitExpToPostfix(){
      StringBuffer[][] testCases = {{new StringBuffer("3+4"), new StringBuffer("3 4 +")},
                                    {new StringBuffer("7/9"), new StringBuffer("7 9 /")},
                                    {new StringBuffer("(6+2)*5-8/4"), new StringBuffer("6 2 + 5 * 8 4 / -")},
                                    {new StringBuffer("1+2*(3^4-5)^(6+7*8)-9"), new StringBuffer("1 2 3 4 ^ 5 - 6 7 8 * + ^ * + 9 -")}};
      for (StringBuffer[] testCase: testCases){
         assertEquals(testCase[1].toString(), InfixToPostfixConverter.convertToPostfix(testCase[0]).toString());
      }
   }
   
   @Test
   public void testConvertMultiDigitExpToPostfix(){
      StringBuffer[][] testCases = {{new StringBuffer("323 + 47"), new StringBuffer("323 47 +")},
                                    {new StringBuffer("75/9"), new StringBuffer("75 9 /")},
                                    {new StringBuffer("(65+2)*52-8/43"), new StringBuffer("65 2 + 52 * 8 43 / -")},
                                    {new StringBuffer("11 + 2 * (3^4 - 5)^(6 + 743423 * 8) - 9333"), 
                                    new StringBuffer("11 2 3 4 ^ 5 - 6 743423 8 * + ^ * + 9333 -")}};
      for (StringBuffer[] testCase: testCases){
         assertEquals(testCase[1].toString(), InfixToPostfixConverter.convertToPostfix(testCase[0]).toString());
      }
   }
}
