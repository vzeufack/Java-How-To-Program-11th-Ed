public class SpellChecker{
   public static void main(String[] args){
      System.out.println(levenshteinDistance("zoologicoarchaeologist", "zoogeologist"));
   }
   
   public static int levenshteinDistance(String s1, String s2){
      int[][] matrix = new int[s2.length()+1][s1.length()+1];
      
      for(int i = 0; i < matrix.length; i++){
         matrix[i][0] = i;
      }
      
      for(int i = 0; i < matrix[0].length; i++){
         matrix[0][i] = i;
      }
      
      
      
      for(int i = 1; i < matrix.length; i++){
         for(int j = 1; j < matrix[i].length; j++){
            int left = matrix[i-1][j];
            int up = matrix[i][j-1];
            int diag = matrix[i-1][j-1];
            int min = Math.min(left, Math.min(up, diag));
            
            matrix[i][j] = s2.charAt(i-1) == s1.charAt(j-1) ? diag : min + 1;
         }
      }
      
      for(int i = 0; i < matrix.length; i++){
         for(int j = 0; j < matrix[i].length; j++){
            System.out.printf("%d ", matrix[i][j]);
         }
         System.out.println();
      }
      
      return matrix[s2.length()][s1.length()];
   }
}