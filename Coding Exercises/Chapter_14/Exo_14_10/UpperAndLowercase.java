import java.util.Scanner;

public class UpperAndLowercase{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      System.out.print("Type a sentence > ");
      String sentence = scan.nextLine();
      
      System.out.printf("%s\n", sentence.toUpperCase());
      System.out.printf("%s\n", sentence.toLowerCase());
   }
}