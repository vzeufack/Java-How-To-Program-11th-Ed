import java.util.Scanner;

public class ThreeLetterWordsFrom5LetterWords{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter a 5 letter word > ");
      String word = scan.nextLine();
      
      for(int i = 0; i < 5; i++){
         for(int j = 0; j < 5; j++){
            for(int k = 0; k < 5; k++){
               System.out.printf("%s\n", "" + word.charAt(i) + word.charAt(j) + word.charAt(k));
            }
         }
      }
   }
}