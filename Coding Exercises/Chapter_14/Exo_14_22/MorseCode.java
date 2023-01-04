public class MorseCode{
   public static void main(String[] args){
      System.out.println(toMorseCode("1"));
   }
   
   public static String toMorseCode(String phrase){
      String[] lettersMorseCodes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
                                    "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
      String[] digitsMorseCodes = {"-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "----."};
                             
      String lowercasedPharse = phrase.toLowerCase();
      StringBuilder result = new StringBuilder();
      
      for(int i = 0; i < phrase.length(); i++){
         if(lowercasedPharse.charAt(i) >= 97)
            result.append(lettersMorseCodes[lowercasedPharse.charAt(i)-97]);
         else
            result.append(digitsMorseCodes[Integer.parseInt(lowercasedPharse.charAt(i) + "")]);
      }
      
      return result.toString();
   }
}