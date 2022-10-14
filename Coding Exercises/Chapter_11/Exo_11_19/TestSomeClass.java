public class TestSomeClass{
   public static void main(String[] args){
      try{
         SomeClass someClass = new SomeClass();
      }
      catch(IllegalArgumentException e){
         System.out.println("Exception caught!");
      }
   }
}