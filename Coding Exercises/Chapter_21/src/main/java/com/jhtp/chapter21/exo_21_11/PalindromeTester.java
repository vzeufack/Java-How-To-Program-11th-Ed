package com.jhtp.chapter21.exo_21_11;

import com.jhtp.chapter21.datastructures.Stack;
import java.util.Scanner;

/**
 *
 * @author vannel
 */
public class PalindromeTester {
   public static void main (String[] args){
      Scanner scanner = new Scanner(System.in);
      String continueAnswer;
      String word;
      
      System.out.println("Welcome to the palindrome tester!");
      do{
         System.out.print("\nEnter a word > ");
         word = scanner.nextLine();         

         if (isPalindrome(word))
            System.out.printf("\"%s\" is a palindrome.%n", word);
         else
            System.out.printf("\"%s\" is not a palindrome.%n", word);
         
         do{
            System.out.print("Would you like to test another word? (y/n) > ");
            continueAnswer = scanner.nextLine();
         }while(!continueAnswer.equalsIgnoreCase("y") && !continueAnswer.equalsIgnoreCase("n"));
         
      }while(continueAnswer.equalsIgnoreCase("y"));

      scanner.close();
      System.out.println("\nThank you!");
   }
   
   public static boolean isPalindrome(String str){      
      Stack<Character> stack = new Stack<>();
      String cleanStr = clean(str);
      
      for (int i = 0; i < Math.floor(cleanStr.length()/2.0); i++){
         if (Character.isLetterOrDigit(cleanStr.charAt(i))) 
            stack.push(cleanStr.charAt(i));
      }
      for (int i = (int)Math.ceil(cleanStr.length()/2.0); i < cleanStr.length(); i++){
         if (Character.isLetterOrDigit(cleanStr.charAt(i)) && cleanStr.charAt(i) != stack.pop())
            return false;
      }      
      return true;
   }
   
   private static String clean(String str){
      String strCopy = str.trim();
      String cleanStr = "";
      for (int i = 0; i < strCopy.length(); i++){
         if (Character.isLetterOrDigit(strCopy.charAt(i)))
            cleanStr += strCopy.charAt(i);
      }
      return cleanStr;
   }
}
