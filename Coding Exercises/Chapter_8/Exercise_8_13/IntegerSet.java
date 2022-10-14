public class IntegerSet{
   private boolean array[];
   
   public IntegerSet(){
      array = new boolean[100];
   }
   
   public boolean[] getArray(){
      return array;
   }
   
   public void setArray(boolean[] array){
      this.array = array;
   }
   
   public static IntegerSet union(IntegerSet set1, IntegerSet set2){
      IntegerSet result = new IntegerSet();
      int n = set1.getArray().length;
      boolean[] resultArray = new boolean[n];
      
      for(int i = 0; i < n; i++){
         resultArray[i] = set1.getArray()[i] || set2.getArray()[i];
      }
      
      result.setArray(resultArray);
      return result;
   }
   
   public static IntegerSet intersection(IntegerSet set1, IntegerSet set2){
      IntegerSet result = new IntegerSet();
      int n = set1.getArray().length;
      boolean[] resultArray = new boolean[n];
      
      for(int i = 0; i < n; i++){
         resultArray[i] = set1.getArray()[i] && set2.getArray()[i];
      }
      
      result.setArray(resultArray);
      return result;
   }
   
   public void insertElement(int k){
      if(k < 0 || k > 100)
         throw new IllegalArgumentException("Cannot insert " + k + "! Value is out of range [0 - 100]");
      array[k] = true;
   }
   
   public void deleteElement(int k){
      if(k < 0 || k > 100)
         throw new IllegalArgumentException("Cannot delete " + k + "! Value is out of range [0 - 100]");
      array[k] = false;
   }
   
   public String toString(){
      String result = "";
      for(int i = 0; i < 100; i++){
         if(array[i])
            result += i + " ";
      }
      
      if(result == "")
         return "---";
      else
         return result;
   }
   
   public boolean isEqualTo(IntegerSet set){
      for(int i = 0; i < array.length; i++){
         if(array[i] != set.getArray()[i])
            return false;
      }
      return true;
   }
}