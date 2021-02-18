package com.jhtp.chapter21.exo_21_12;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InfixToPostfixConverterTest {
   @BeforeEach
   public void setUp() {
   }
   
   @AfterEach
   public void tearDown() {
   }

   @Test
   public void testConvertSingleDigitExpToPostfix(){
      StringBuffer[][] testCases = {{new StringBuffer("3+4"), new StringBuffer("34+")},
                                    {new StringBuffer("7/9"), new StringBuffer("79/")},
                                    {new StringBuffer("(6+2)*5-8/4"), new StringBuffer("62+5*84/-")},
                                    {new StringBuffer("1+2*(3^4-5)^(6+7*8)-9"), new StringBuffer("1234^5-678*+^*+9-")}};
      for (StringBuffer[] testCase: testCases){
         assertEquals(testCase[1].toString(), InfixToPostfixConverter.convertToPostfix(testCase[0]).toString());
      }
   }
}
