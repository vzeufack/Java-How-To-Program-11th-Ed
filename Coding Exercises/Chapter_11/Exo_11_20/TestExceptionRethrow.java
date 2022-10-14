public class TestExceptionRethrow{
   public static void main(String[] args){
      try{
         someMethod();
      }
      catch(Exception e){
         e.printStackTrace();
      }
   }
   
   private static void someMethod() throws Exception{
      try{
         someMethod2();
      }
      catch(Exception e){
         System.out.println("Exception caught in someMethod");
         throw new Exception(e);
      }
   }
   
   private static void someMethod2() throws Exception{
      throw new Exception();
   }
}