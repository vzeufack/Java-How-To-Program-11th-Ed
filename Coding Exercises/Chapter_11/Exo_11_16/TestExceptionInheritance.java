public class TestExceptionInheritance{
   public static void main(String[] args){
      try{
         methodB();
      }
      catch(ExceptionA e){
         System.out.println("Exception A successfully caught exception B");
      }
      
      try{
         methodC();
      }
      catch(ExceptionA e){
         System.out.println("Exception A successfully caught exception C");
      }
   }
   
   private static void methodB() throws ExceptionB{
      throw new ExceptionB();
   }
   
   private static void methodC() throws ExceptionC{
      throw new ExceptionC();
   }

}