public class IntToChar{
   public static void main(String[] args){
      for(int i = 0; i <= 255; i++){
         System.out.printf("%d -> %s\n", i, Character.toChars(i)[0]);
      }
   }
}