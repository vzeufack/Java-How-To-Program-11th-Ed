package Exercise_21_13;

import Exercise_21_12.InfixToPostfixConverter;
import com.deitel.datastructures.Stack;

public class PostfixEvaluator {
    public static void main(String[] args) {
        int a = 5^2;
        System.out.println(a);
    }
    public static int evaluatePostfixExpression(StringBuffer postfix){
        postfix.append(")");
        int i = 0;
        Character current = postfix.charAt(i);
        Stack<Integer> stack = new Stack<>();

        while(!current.equals(')')){
            if(Character.isDigit(current)){
                stack.push(Integer.parseInt(current + ""));
            }
            else if(InfixToPostfixConverter.isOperator(current)){
                int temp = calculate(stack.pop(), stack.pop(), current);
                stack.push(temp);
            }
            else{}

            current = postfix.charAt(++i);
        }

        return stack.pop();
    }

    private static int calculate(int x, int y, Character operator){
        switch(operator){
            case '+':
                return y + x;
            case '-':
                return y - x;
            case '*':
                return y * x;
            case '/':
                return y / x;
            case '%':
                return y % x;
            default:
                return (int)Math.pow(y, x);
        }
    }
}
