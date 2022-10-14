import java.io.IOException;

public class TestExceptionPolymorphism{
   public static void main(String[] args){
      try{
         throw new ExceptionA();
      }
      catch(Exception e){
         System.out.println("Exception A caught!");
      }
      
      try{
         throw new ExceptionB();
      }
      catch(Exception e){
         System.out.println("Exception B caught!");
      }
      
      try{
         throw new NullPointerException();
      }
      catch(Exception e){
         System.out.println("NullPointerException caught!");
      }
      
      try{
         throw new IOException();
      }
      catch(Exception e){
         System.out.println("IOException caught!");
      }
   }
}