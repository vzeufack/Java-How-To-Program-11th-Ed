public class CatchingExceptionsOuterScope{
   public static void main(String[] args){
      try{
         someMethod();
      }
      catch(NullPointerException e){
         System.out.println("Exception caught in main!");
      }
   }
   
   private static void someMethod() throws NullPointerException{
      try{
         throw new NullPointerException();
      }
      catch(IllegalArgumentException e){
         System.out.println("Exception caught in someMethod!");
      }
      finally{
         System.out.println("Exception not caught in someMethod!");
      }
   }
}