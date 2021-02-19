package com.jhtp.chapter21.exo_21_13;

import java.util.Arrays;
import java.util.Scanner;

import com.jhtp.chapter21.datastructures.Stack;
import com.jhtp.chapter21.exo_21_12.InfixToPostfixConverter;

/**
 * Evaluates a postfix expression
 * Assumes expressions are valid
 * Solution for both Exercise 21_13 and Exercise 21_14
 */
public class PostfixEvaluator {
   
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      StringBuffer infix = new StringBuffer();
      Character[] validOperators = {'+', '-', '*', '/', '^', '%'};
      
      System.out.println("Welcome to the expression evaluator!");
      System.out.printf("Note: a valid expression consists of integers and operators %s%n", Arrays.asList(validOperators));
      System.out.println("Example: 5 + 6 - 28 / 7");
    
      do{
         System.out.print("\nEnter an expression (or \"s\" to stop) > ");
         infix.delete(0, infix.length());
         infix.append(scanner.nextLine());
         if (!infix.toString().equalsIgnoreCase("s"))
            System.out.printf("%s = %d%n", infix, evaluatePostfixExpression(InfixToPostfixConverter.convertToPostfix(infix)));

      }while (!infix.toString().equalsIgnoreCase("s"));

      scanner.close();
   }

   public static Integer evaluatePostfixExpression(StringBuffer expression){
      Stack<Integer> stack = new Stack<>();
      StringBuffer currentInteger = new StringBuffer();
      int i = 0;

      while (i < expression.length()){
         Character currentChar = expression.charAt(i);

         if (Character.isDigit(currentChar)){
            currentInteger.delete(0, currentInteger.length());
            currentInteger.append(currentChar);

            while(i+1 < expression.length() && Character.isDigit(expression.charAt(i+1))){
               currentInteger.append(expression.charAt(++i));
            }
            stack.push(Integer.parseInt(currentInteger.toString()));
         }
         else if (InfixToPostfixConverter.isOperator(currentChar)){
            Integer op2 = stack.pop();
            Integer op1 = stack.pop();
            stack.push(calculate(op1, op2, currentChar));
         }
         else{}

         i++;
      }
      
      if (stack.isEmpty())
         return null;

      return stack.pop();
   }

   private static Integer calculate(Integer op1, Integer op2, Character operator){
      switch(operator){
         case '+':
            return op1 + op2;
         case '-':
            return op1 - op2;
         case '*':
            return op1 * op2;
         case '/':
            return op1 / op2;
         case '%':
            return op1 % op2;
         case '^':
            return (int) Math.pow(op1, op2);
         default:
            return null;
      }
   }
}
