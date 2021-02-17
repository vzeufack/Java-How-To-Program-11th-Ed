package com.jhtp.chapter21.exo_21_11;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author vannel
 */
public class PalindromeTesterTest {
   
   public PalindromeTesterTest() {
   }
   
   @BeforeEach
   public void setUp() {
   }
   
   @AfterEach
   public void tearDown() {
   }

   @Test
   public void testisPalindromeWithValidPalindromes() {
      String[] palindromes = {"", "abba", "aba", "aaaaa", " a1_22.1a  "};
      for (String palindrome: palindromes){
         System.out.println(PalindromeTester.isPalindrome(palindrome));
         assertTrue(PalindromeTester.isPalindrome(palindrome));
      }
   }

   @Test
   public void testisPalindromeWithInvalidPalindromes() {
      String[] invalidPalindromes = {"sdfs", "eera", "asdffs", " a1_33r22.1a  "};
      for (String invalidPalindrome: invalidPalindromes)
         assertFalse(PalindromeTester.isPalindrome(invalidPalindrome));
   }   
}
