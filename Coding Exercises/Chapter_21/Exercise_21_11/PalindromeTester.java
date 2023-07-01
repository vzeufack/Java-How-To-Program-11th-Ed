package Exercise_21_11;
import com.deitel.datastructures.Stack;
import java.util.Scanner;
public class PalindromeTester {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String answer = "";
        do{
            System.out.printf("Enter a word (or -1 to stop) > ");
            answer = scan.nextLine();
            if(!answer.equals("-1")){
                if(isPalindrome(answer))
                    System.out.printf("%s is a palindrome!\n", answer);
                else
                    System.out.printf("%s is not a palindrome!\n", answer);
            }
        }while(!answer.equals("-1"));
    }

    public static boolean isPalindrome(String str){
        String cleanStr = str.replaceAll("[^[A-Z][a-z][0-9]]", "");
        System.out.println(cleanStr);
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < cleanStr.length()/2; i++){
            stack.push(cleanStr.charAt(i));
        }

        int i = cleanStr.length()%2 == 0? cleanStr.length()/2: cleanStr.length()/2+1;
        boolean isSameCharacter = true;
        while(i < cleanStr.length() && isSameCharacter){
            isSameCharacter = stack.pop().equals(cleanStr.charAt(i));
            i++;
        }

        return isSameCharacter;
    }
}
