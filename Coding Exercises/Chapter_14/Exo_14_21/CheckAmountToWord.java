public class CheckAmountToWord{
   public static void main(String[] args){
      System.out.println(convert(108.05));
   }
   
   public static String convert(double amount){
      String amtStr = String.valueOf(amount);
      String[] splittedAmt = amtStr.split("\\.");
      String intPart = splittedAmt[0];
      String decimalPart = splittedAmt[1];
      
      if(decimalPart.equals("0")){
         return convertIntegerPart(intPart, true).toString();
      }
      else{
         return convertIntegerPart(intPart, false).append(" and " + convertDecimalPart(decimalPart)).toString();
      }
   }
   
   private static StringBuilder convertIntegerPart(String intPart, boolean addAnd){
      if(intPart.length() == 1 && intPart.charAt(0) == '0'){
         return new StringBuilder("zero");
      }
      
      String intPartZeroFilled = "";
      for(int i = 0; i < 3 - intPart.length(); i++){
         intPartZeroFilled += "0";
      }
      intPartZeroFilled += intPart;
      
      String[] digits = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
      String[] tenToNineTeen = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
      String[] tens = {"twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
      
      StringBuilder result = new StringBuilder();
      
      if(intPartZeroFilled.charAt(0) != '0'){
         result.append(digits[Integer.parseInt(intPartZeroFilled.charAt(0) + "") - 1] + " " + "hundred");
         if(intPartZeroFilled.charAt(1) != '0' || intPartZeroFilled.charAt(2) != '0')
            if(addAnd)
               result.append(" and ");
            else
               result.append(" ");
      }
      
      if(intPartZeroFilled.charAt(1) != '0'){
         if(intPartZeroFilled.charAt(1) == '1')
            result.append(tenToNineTeen[Integer.parseInt(intPartZeroFilled.charAt(2) + "")]);
         else
            result.append(tens[Integer.parseInt(intPartZeroFilled.charAt(1) + "")-2] + " " 
                                                + digits[Integer.parseInt(intPartZeroFilled.charAt(2) + "") - 1]);
      }
      else if (intPartZeroFilled.charAt(2) != '0')
         result.append(digits[Integer.parseInt(intPartZeroFilled.charAt(2) + "") - 1]);
      else{}
      
      return result;          
   }
   
   private static StringBuilder convertDecimalPart(String decimalPart){
      StringBuilder result = new StringBuilder();
      
      result.append(Integer.parseInt(decimalPart) + "/");
         
      if(decimalPart.length() == 1)
         result.append("10");
      else
         result.append("100");
      
      return result;       
   }
}