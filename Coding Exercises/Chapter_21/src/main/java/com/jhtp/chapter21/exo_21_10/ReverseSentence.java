package com.jhtp.chapter21.exo_21_10;

import com.jhtp.chapter21.datastructures.Stack;

/**
 * Prints a sentence in reverse using a stack.
 * @author vannel
 */
public class ReverseSentence {
   public static void main (String[] args){
      String sentence = "This is how to reverse a sentence using a stack.";
      System.out.printf("%s%n", sentence);
      reverseSentence(sentence).print();
   }
   
   /**
    * Reverses a sentence.
    * @param sentence:String.
    * @return reversedSentence:String.
    */
   public static Stack<String> reverseSentence (String sentence){
      Stack<String> stack = new Stack<>();
      String str = sentence.trim();
      
      if (str.equals(""))
         return stack;
      else{        
         int i = 0;
         while (i < sentence.length()){
            String currentWord = "";
            while (i < sentence.length() && !Character.isWhitespace(str.charAt(i))){
               if (Character.isLetterOrDigit(str.charAt(i)))
                  currentWord += str.charAt(i);
               i++;
            }
            if (!currentWord.equals(""))
               stack.push(currentWord);
            i++;
         }
      }
      return stack;
   }
}
