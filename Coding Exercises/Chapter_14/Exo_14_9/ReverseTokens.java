import java.util.Scanner;

public class ReverseTokens{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      System.out.print("Type a sentence > ");
      String sentence = scan.nextLine();
      String[] splittedSentence = sentence.split(" ");
      
      for(int i = splittedSentence.length - 1; i >= 0; i--){
         System.out.print(splittedSentence[i] + " ");
      }
   }
}