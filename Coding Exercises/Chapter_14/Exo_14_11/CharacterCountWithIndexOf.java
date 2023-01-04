import java.util.Scanner;

public class CharacterCountWithIndexOf{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter a sentence > ");
      String sentence = scan.nextLine();
      System.out.print("Enter a character to search > ");
      String c = scan.nextLine();
      
      System.out.printf("%c occurs %d times\n", c.charAt(0), countCharacter(sentence, c.charAt(0)));
      
      countAllCharacters(sentence);
   }
   
   private static int countCharacter(String sentence, char c){
      int i = 0;
      int count = 0;
      
      while(i < sentence.length()){
         i = sentence.indexOf(c, i);
         if(i != -1){
            count++;
            i++;
         }
         else
            break;
      }
      
      return count;
   }
   
   private static void countAllCharacters(String sentence){
      char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 
                         'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
      
      for(int i = 0; i < alphabet.length; i++){
         System.out.printf("%c -> %d\n", 
                           alphabet[i], 
                           countCharacter(sentence, alphabet[i]) + countCharacter(sentence, Character.toUpperCase(alphabet[i])));
      }
   }
}