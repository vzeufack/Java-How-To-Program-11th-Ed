package Exercise_21_13;

import Exercise_21_12.InfixToPostfixConverter;
import com.deitel.datastructures.Stack;

public class PostfixEvaluator {
    public static void main(String[] args) {
        int a = 5^2;
        System.out.println(a);
    }
    public static int evaluatePostfixExpression(StringBuffer postfix){
        postfix.append(" )");
        String[] tokens = postfix.toString().split(" ");

        int i = 0;
        String current = tokens[i];
        Stack<Integer> stack = new Stack<>();

        while(!current.equals(")")){
            if(current.matches("-?\\d+"))
                stack.push(Integer.parseInt(current + ""));
            else{
                int temp = calculate(stack.pop(), stack.pop(), current.charAt(0));
                stack.push(temp);
            }

            current = tokens[++i];
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
