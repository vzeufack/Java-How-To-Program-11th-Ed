import java.util.Scanner;

public class StartWithB{
   public static void main (String[] args){
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter a sentence > ");
      String sentence = scan.nextLine();
      String[] splittedSentence = sentence.split(" ");
      
      for(int i = 0; i < splittedSentence.length; i++){
         if(splittedSentence[i].startsWith("b"))
            System.out.println(splittedSentence[i]);
         
         if(splittedSentence[i].endsWith("ED"))
            System.out.println(splittedSentence[i]);
      }
   }
}