package Exercise_21_10;
import com.deitel.datastructures.Stack;

import java.util.Scanner;

public class PrintSentenceInReverse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter a sentence > ");
        String sentence = scan.nextLine();

        String[] words = sentence.split(" ");
        Stack<String> stack = new Stack<>();

        for(String word: words){
            stack.push(word);
        }

        while(!stack.isEmpty()){
            System.out.printf("%s ", stack.pop());
        }
    }
}
