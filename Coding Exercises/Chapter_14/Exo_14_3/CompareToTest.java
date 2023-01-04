import java.util.Scanner;

public class CompareToTest{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter the first string to compare\n> ");
      String s1 = scan.nextLine();
      System.out.print("Enter the second string to compare\n> ");
      String s2 = scan.nextLine();
      
      int comparison = s1.compareTo(s2);
      
      if(comparison == 0)
         System.out.println("s1 = s2");
      else if(comparison > 0)
         System.out.println("s1 > s2");
      else
         System.out.println("s1 < s2");
   }
}