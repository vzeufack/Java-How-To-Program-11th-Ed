package com.jhtp.chapter21.exo_21_12;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Hashtable;

import com.jhtp.chapter21.datastructures.Stack;

/**
 * @author Vannel 
 * Converts infix notation to postix notation
 */
public class InfixToPostfixConverter {
   private static Character[] validOperators = {'+', '-', '*', '/', '^', '%'};

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      StringBuffer infix = new StringBuffer();
      String continueAnswer;
      System.out.println("Welcome to the infix to postfix converter!");
      System.out.printf("Note: a valid expression consists of integers and operators %s%n", Arrays.asList(validOperators));
      System.out.println("Example: 5 + 6 - 28 / 7");
    
      do{
         System.out.print("\nEnter an expression > ");
         infix.delete(0, infix.length());
         infix.append(scanner.nextLine());
         System.out.printf("Postix = %s%n", convertToPostfix(infix));
         do{
            System.out.print("Would you like to convert another expression? (y/n) > ");
            continueAnswer = scanner.nextLine();
         }while(!continueAnswer.equalsIgnoreCase("y") && !continueAnswer.equalsIgnoreCase("n"));
      }while (continueAnswer.equalsIgnoreCase("y"));

      scanner.close();     
   }

   public static StringBuffer convertToPostfix (StringBuffer infix){
      StringBuffer infixCopy = new StringBuffer(infix.toString());
      StringBuffer postfix = new StringBuffer();
      Stack<Character> stack = new Stack<>();
      Character topCharInStack;

      stack.push('(');
      infixCopy.append(')');
      
      int i = 0;
      while (!stack.isEmpty() && i < infixCopy.length()){
         Character currentChar = infixCopy.charAt(i);

         if (Character.isDigit(currentChar)){  
            postfix.append(currentChar);
            while (i+1 < infixCopy.length() && Character.isDigit(infixCopy.charAt(i+1)))
               postfix.append(infixCopy.charAt(++i));
            postfix.append(" ");
         }         
         else if (currentChar.compareTo('(') == 0){
            stack.push('(');
         }
         else if (isOperator(currentChar)){
            topCharInStack = stack.peek();

            while (isOperator(topCharInStack) && precedence(topCharInStack, currentChar) >= 0){
               postfix.append(stack.pop() + " ");
               topCharInStack = stack.peek();
            }
            stack.push(currentChar);
         }
         else if (currentChar.compareTo(')') == 0){
            topCharInStack = stack.peek();
            while (isOperator(topCharInStack)){
               postfix.append(stack.pop() + " ");
               topCharInStack = stack.peek();
            }
            if (topCharInStack.compareTo('(') == 0)
               stack.pop();
         }
         else{}
         i++;
      }
      
      if (postfix.length() >= 1)
         postfix.setLength(postfix.length() - 1);
      return postfix;
   }

   public static boolean isOperator(Character c){
      List<Character> validOperatorsList = Arrays.asList(validOperators);
      return validOperatorsList.contains(c);
   }

   private static int precedence(Character op1, Character op2){
      Map<Character, Integer> precedenceMap = new Hashtable<Character, Integer>();
      precedenceMap.put('+', 0);
      precedenceMap.put('-', 0);
      precedenceMap.put('*', 1);
      precedenceMap.put('/', 1);
      precedenceMap.put('%', 1);
      precedenceMap.put('^', 2);

      return precedenceMap.get(op1) - precedenceMap.get(op2);
   }
}
