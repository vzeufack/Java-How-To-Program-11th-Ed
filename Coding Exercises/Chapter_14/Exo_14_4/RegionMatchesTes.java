import java.util.Scanner;

public class RegionMatchesTes{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter the first string to compare\n> ");
      String s1 = scan.nextLine();
      System.out.print("Enter the second string to compare\n> ");
      String s2 = scan.nextLine();
      System.out.print("Enter the starting index for the comparison > ");
      int startIdx = scan.nextInt();
      System.out.print("Enter the number of characters to compare > ");
      int numOfChars = scan.nextInt();
      
      if(s1.regionMatches(startIdx, s2, startIdx, numOfChars))
         System.out.println("The regions matches!");
      else
         System.out.println("The regions do not match!");
   }
}