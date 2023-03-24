import java.util.Scanner;
import java.util.regex.Pattern;

public class DuplicateWordRemoval{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter a sentence > ");
      String sentence = scan.nextLine();
      
      System.out.println("\nList of unique words sorted alphabetically:");
      Pattern.compile("\\s+")
             .splitAsStream(sentence)
             .map(String::toLowerCase)
             .distinct()
             .sorted()
             .forEach(System.out::println);
   }
}