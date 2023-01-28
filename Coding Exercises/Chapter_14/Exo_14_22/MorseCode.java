public class MorseCode{
   public static void main(String[] args){
      System.out.println(toMorseCode("Argentina will win World Cup 2022"));
   }
   
   public static String toMorseCode(String phrase){
      String[] lettersMorseCodes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
                                    "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
      String[] digitsMorseCodes = {"-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----."};                             
      String lowercasedPharse = phrase.toLowerCase();
      StringBuilder result = new StringBuilder();
      
      for(int i = 0; i < phrase.length(); i++){
         int c = lowercasedPharse.charAt(i);
         if(c >= 97 && c <= 122)
            result.append(lettersMorseCodes[c-97] + " ");
         else if (c >= 48 && c <= 57)
            result.append(digitsMorseCodes[Integer.parseInt(lowercasedPharse.charAt(i) + "")] + " ");
         else
            result.append("  ");
      }
      
      return result.toString().trim();
   }
   
   public static String toEnglish(String code){
      StringBuilder result = new StringBuilder();
      String[] words = code.split("   ");
      
      for(String word: words){
         String[] letterCodes = word.split(" ");
         for(String letterCode: letterCodes){
            result.append(toEnglishChar(letterCode));
         }
         result.append(" ");
      }
      
      return result.toString().trim();
   }
   
   private static String toEnglishChar(String letterCode){
      switch(letterCode){
         case ".-":
            return "a"; 
         case "-...":
            return "b"; 
         case "-.-.":
            return "c"; 
         case "-..":
            return "d"; 
         case ".":
            return "e"; 
         case "..-.":
            return "f"; 
         case "--.":
            return "g"; 
         case "....":
            return "h"; 
         case "..":
            return "i"; 
         case ".---":
            return "j"; 
         case "-.-":
            return "k"; 
         case ".-..":
            return "l"; 
         case "--":
            return "m"; 
         case "-.":
            return "n"; 
         case "---":
            return "o"; 
         case ".--.":
            return "p"; 
        case "--.-":
            return "q"; 
         case ".-.":
            return "r"; 
         case "...":
            return "s"; 
         case "-":
            return "t"; 
         case "..-":
            return "u"; 
         case "...-":
            return "v"; 
         case ".--":
            return "w"; 
         case "-..-":
            return "x"; 
         case "-.--":
            return "y"; 
         case "--..":
            return "z"; 
         case "-----":
            return "0"; 
         case ".----":
            return "1"; 
         case "..---":
            return "2"; 
         case "...--":
            return "3"; 
         case "....-":
            return "4"; 
         case ".....":
            return "5"; 
         case "-....":
            return "6"; 
         case "--...":
            return "7"; 
         case "---..":
            return "8"; 
         case "----.":
            return "9"; 
         default:
            return "";        
      }
   }
}