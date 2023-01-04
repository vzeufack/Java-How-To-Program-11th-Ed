import java.util.Scanner;

public class PigLatin{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter a sentence > ");
      String sentence = scan.nextLine();
      String[] splittedSentence = sentence.split(" ");
      
      for(String word: splittedSentence){
         printLatinWord(word);
      }
   }
   
   private static void printLatinWord(String word){
      System.out.print(word.substring(1, word.length()) + word.charAt(0) + "ay ");
   }
}