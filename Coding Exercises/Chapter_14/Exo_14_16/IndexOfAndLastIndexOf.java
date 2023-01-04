public class IndexOfAndLastIndexOf{
   public static void main(String[] args){
      String test = "programming is fun!";
      System.out.printf("%d\n", indexOf(test, "mm"));
      System.out.printf("%d\n", indexOf(test, "s", 10));
      System.out.printf("%d\n", indexOf(test, "ing"));
      System.out.printf("%d\n", lastIndexOf(test, "ing"));
      System.out.printf("%d\n", lastIndexOf(test, "ing", 10));
      System.out.printf("%d\n", lastIndexOf(test, "ing", 5));
      System.out.printf("%d\n", indexOf(test, 'n'));
      System.out.printf("%d\n", indexOf(test, 'n', 10));
      System.out.printf("%d\n", lastIndexOf(test, 'n'));
      System.out.printf("%d\n", lastIndexOf(test, 'n', 10));
   }
   
   private static int indexOf(String str, String key){      
      if(key.length() > str.length())
         return -1;
      
      for(int i = 0; i < str.length(); i++){
         int j = 0;
         
         while(i < str.length() && j < key.length() && key.charAt(j) == str.charAt(i)){
            i++;
            j++;
         }
         
         if(j == key.length())
            return i-key.length();
      }
      
      return -1;
   }
   
   private static int indexOf(String str, int ch){
      char c = Character.toChars(ch)[0]; 
        
      for(int i = 0; i < str.length(); i++){
         if(str.charAt(i) == c)
            return i;
      }
      
      return -1;
   }
   
   private static int indexOf(String str, String key, int fromIndex){  
      if(key.length() - fromIndex > str.length())
         return -1;
      
      for(int i = fromIndex; i < str.length(); i++){
         int j = 0;
         
         while(i < str.length() && j < key.length() && key.charAt(j) == str.charAt(i)){
            i++;
            j++;
         }
         
         if(j == key.length())
            return i-key.length();
      }
      
      return -1;
   }
   
   private static int indexOf(String str, int ch, int fromIndex){
      char c = Character.toChars(ch)[0]; 
        
      for(int i = fromIndex; i < str.length(); i++){
         if(str.charAt(i) == c)
            return i;
      }
      
      return -1;
   }
   
   private static int lastIndexOf(String str, String key){
      if(key.length() > str.length())
         return -1;
      
      for(int i = str.length()-1; i >= 0 ; i--){
         int j = key.length()-1;
         
         while(i >= 0 && j >= 0 && key.charAt(j) == str.charAt(i)){
            i--;
            j--;
         }
         
         if(j == -1)
            return i+1;
      }
      
      return -1;      
   }
   
   private static int lastIndexOf(String str, int ch){
      char c = Character.toChars(ch)[0]; 
        
      for(int i = str.length()-1; i >= 0; i--){
         if(str.charAt(i) == c)
            return i;
      }
      
      return -1;
   }
   
   
   
   private static int lastIndexOf(String str, String key, int fromIndex){
      if(key.length() - fromIndex > str.length())
         return -1;
      
      for(int i = fromIndex; i >= 0 ; i--){
         int j = key.length()-1;
         
         while(i >= 0 && j >= 0 && key.charAt(j) == str.charAt(i)){
            i--;
            j--;
         }
         
         if(j == -1)
            return i+1;
      }
      
      return -1;      
   }
   
   private static int lastIndexOf(String str, int ch, int fromIndex){
      char c = Character.toChars(ch)[0]; 
        
      for(int i = fromIndex; i >= 0; i--){
         if(str.charAt(i) == c)
            return i;
      }
      
      return -1;
   }
}