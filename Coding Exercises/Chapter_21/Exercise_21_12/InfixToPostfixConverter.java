package Exercise_21_12;

import com.deitel.datastructures.Stack;

import java.util.Arrays;
import java.util.HashMap;

public class InfixToPostfixConverter {
    public static String convertToPostfix(String infix){
        Stack<Character> stack = new Stack<>();
        stack.push('(');
        StringBuilder postfix = new StringBuilder("");
        infix += ")";
        int i = 0;

        while(!stack.isEmpty()){
            Character current = infix.charAt(i);

            if (Character.isDigit(current))
                postfix.append(current + " ");

            else if (current.equals('('))
                stack.push(current);

            else if (isOperator(current)) {
                while (isOperator(stack.peek()) && precedence(current, stack.peek()) <= 0)
                    postfix.append(stack.pop() + " ");
                stack.push(current);
            }

            else if (current.equals(')')){
                while (!stack.peek().equals('('))
                    postfix.append(stack.pop() + " ");
                stack.pop();
            }
            else{}

            i++;
        }

        return postfix.substring(0, postfix.length()-1);
    }

    public static boolean isOperator(Character c){
        String operators = "+-*/^%";
        return operators.contains(c + "");
    }

    private static int precedence(Character op1, Character op2){
        HashMap<Character, Integer> precedenceValues = new HashMap<Character, Integer>();
        precedenceValues.put('+', 1);
        precedenceValues.put('-', 1);
        precedenceValues.put('*', 2);
        precedenceValues.put('/', 2);
        precedenceValues.put('%', 2);
        precedenceValues.put('^', 3);

        return precedenceValues.get(op1) - precedenceValues.get(op2);
    }
}
