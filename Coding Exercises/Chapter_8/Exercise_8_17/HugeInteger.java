public class HugeInteger{
   private static final int SIZE = 40;
   private int[] array;
   
   public HugeInteger(){
      array = new int[SIZE];
   }
   
   public HugeInteger(int[] array){
      this.array = new int[SIZE];
      for(int i = 0; i < SIZE; i++){
         this.array[i] = array[i];
      }
   }
   
   public HugeInteger(String array){
      this.array = new int[SIZE];
      parse(array);
   }
   
   //Extracts digits from the given string and place them into the array
   public void parse(String s){
      if(s == null || s.length() == 0 || s.length() > 40)
         throw new IllegalArgumentException("Cannot parse given string! Length must be between [1-40]");
   
      int j = SIZE - 1;   
      for(int i = s.length()-1; i >= 0; i--){
         array[j--] = Integer.parseInt(s.charAt(i) + "");
      }
   }
   
   public int[] getArray(){
      return array;
   }
   
   
   //returns the huge integer asa  String
   public String toString(){
      String result = "";
      
      for(int i = 0; i < array.length; i++){
         result += array[i];
      }
      
      return result;
   }
   
   //adds two huge iIntegers
   public static HugeInteger add(HugeInteger a, HugeInteger b){
      HugeInteger result = new HugeInteger();
      int[] array = new int[SIZE];
      int carry = 0;
      
      for(int i = SIZE - 1; i >= 0; i--){
         array[i] = (a.getArray()[i] + b.getArray()[i] + carry)%10;
         carry = (a.getArray()[i] + b.getArray()[i] + carry)/10;
      }
       
      return new HugeInteger(array);
   }
   
   //subtract two huge iIntegers
   public static HugeInteger subtract(HugeInteger a, HugeInteger b){
      HugeInteger min, max;
      boolean isNegative = false;
      
      if(a.isLessThan(b)){
         max = a;
         min = b;
      }
      else{
         max = b;
         min = a;
         isNegative = true;
      }
      
      
      HugeInteger result = new HugeInteger();
      int[] array = new int[SIZE];
      int carry = 0;
      int lastNonNegativeNumberIndex = -1;
      
      for(int i = SIZE - 1; i >= 0; i--){
         int tempResult = min.getArray()[i] - max.getArray()[i] - carry;
         if(tempResult < 0){
            array[i] = tempResult + 10;
            carry = 1;
         }else{
            array[i] = tempResult;
            carry = 0;
         }
         
         if(array[i] != 0)
            lastNonNegativeNumberIndex = i;
      }
      
      if(isNegative){
         array[lastNonNegativeNumberIndex] = -1 * array[lastNonNegativeNumberIndex];
      }
       
      return new HugeInteger(array);
   }
   
   public boolean isEqualTo(HugeInteger n){
      for(int i = 0; i < SIZE; i++){
         if(array[i] != n.getArray()[i])
            return false;
      }
      return true;
   }
   
   public boolean isNotEqualTo(HugeInteger n){
      for(int i = 0; i < SIZE; i++){
         if(array[i] != n.getArray()[i])
            return true;
      }
      return false;   
   }
   
   public boolean isGreaterThan(HugeInteger n){
      for(int i = 0; i < SIZE; i++){
         if(array[i] > n.getArray()[i])
            return true;
      }
      return false;
   }
   
   public boolean isLessThan(HugeInteger n){
      for(int i = 0; i < SIZE; i++){
         if(array[i] < n.getArray()[i])
            return true;
      }
      return false;
   }
   
   public boolean isGreaterThanOrEqualTo(HugeInteger n){
      for(int i = 0; i < SIZE; i++){
         if(array[i] < n.getArray()[i])
            return false;
      }
      return true;
   }
   
   public boolean isLessThanOrEqualTo(HugeInteger n){
      for(int i = 0; i < SIZE; i++){
         if(array[i] > n.getArray()[i])
            return false;
      }
      return true;   
   }
   
   public boolean isZero(){
      for(int i = 0; i < SIZE; i++){
         if(array[i] != 0)
            return false;
      }
      return true;
   }
}