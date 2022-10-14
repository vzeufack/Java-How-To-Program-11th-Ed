public class TestCatchBlocksOrder{
   public static void main(String[] args){
      try{
         throw new NullPointerException();
      }
      catch(NullPointerException e){}
      catch(Exception e){}
   }
}