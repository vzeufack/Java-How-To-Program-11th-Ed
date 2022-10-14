import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * This class tests the concept of Exception Transfer
 * According to theory, if an Exception is thrown in a try statement
 * and not caught in any of the following catch statements, then the Exception
 * is thrown to the following try statement.
 */
public class ExceptionTransferTest{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      
      try{
         int input = scan.nextInt();
      }
      catch(Exception e){
         System.out.println(e.getCause());
         //System.out.println("Execption caught in 1st try statement");
      }
   }
}