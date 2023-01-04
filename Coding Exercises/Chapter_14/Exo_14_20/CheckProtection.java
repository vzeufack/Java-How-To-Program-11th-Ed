public class CheckProtection{
   public static void main(String[] args){
      System.out.println(getCheckProtectedAmount("1230.60"));
      System.out.println(getCheckProtectedAmount("99.87"));
   }
   
   public static String getCheckProtectedAmount(String amount){
      try{
         Double.parseDouble(amount);
      }
      catch(NumberFormatException ex){
         throw new IllegalArgumentException("Invalid amount");
      }
      
      if(amount.length() == 9)
         return amount;
      else if (amount.length() > 9)
         throw new IllegalArgumentException("Amount is too large!");
      else{
         StringBuilder result = new StringBuilder();
         for(int i = 0; i < 9 - amount.length(); i++){
            result.append("*");
         }
         result.append(amount);
         return result.toString();
      }
   }
}