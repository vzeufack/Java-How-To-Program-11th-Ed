public class TwoDBooleanArray{
   public static void main(String[] args){
      boolean[][] array = {{true, false, true, true, true, true, false,},
                           {false, true, false}};
      print(array);
   }
   
   public static void print(boolean[][] array){
      System.out.printf(" ");
      for(int i = 0; i < array[0].length; i++){
         System.out.printf("%3d", i); 
      }
      System.out.println();
      
      for(int i = 0; i < array.length; i++){
         System.out.printf("%-3d", i);
         for(int j = 0; j < array[i].length; j++){
            System.out.printf("%-3s", array[i][j]?"*":" ");
         }
         System.out.println();
      }
   }
}