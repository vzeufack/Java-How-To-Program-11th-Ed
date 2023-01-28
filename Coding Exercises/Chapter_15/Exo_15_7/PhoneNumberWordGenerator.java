import java.util.Formatter;
import java.io.FileNotFoundException;
import java.util.FormatterClosedException;

public class PhoneNumberWordGenerator{
   public static void main(String[] args){
      printWords(6392277);
   }
   
   private static String[] generateWords(int phoneNumber){
      String[] words = new String[2187];
      int i = 0;
      
      StringBuilder currentWord = new StringBuilder();
      for(int a = 0; a < 3; a++){         
         currentWord.append(getLetters((phoneNumber/1000000)%10)[a]);
         for(int b = 0; b < 3; b++){
            currentWord.append(getLetters((phoneNumber/100000)%10)[b]);
            for(int c = 0; c < 3; c++){
               currentWord.append(getLetters((phoneNumber/10000)%10)[c]);
               for(int d = 0; d < 3; d++){
                  currentWord.append(getLetters((phoneNumber/1000)%10)[d]);
                  for(int e = 0; e < 3; e++){
                     currentWord.append(getLetters((phoneNumber/100)%10)[e]);
                     for(int f = 0; f < 3; f++){
                        currentWord.append(getLetters((phoneNumber/10)%10)[f]);
                        for(int g = 0; g < 3; g++){
                           currentWord.append(getLetters(phoneNumber%10)[g]);
                           words[i++] = currentWord.toString();
                           currentWord.delete(6, 7);
                        }
                        currentWord.delete(5, 7);
                     }
                     currentWord.delete(4, 7);
                  }
                  currentWord.delete(3, 7);
               }
               currentWord.delete(2, 7);
            }
            currentWord.delete(1, 7);
         }
         currentWord.delete(0, 7);
      }
      
      return words;
   }
   
   private static char[] getLetters(int digit){
      char[] letters = new char[3];
      switch(digit){
         case 2:
            letters[0] = 'A'; 
            letters[1] = 'B';
            letters[2] = 'C';
            return letters;
         case 3:
            letters[0] = 'D'; 
            letters[1] = 'E';
            letters[2] = 'F';
            return letters;
         case 4:
            letters[0] = 'G'; 
            letters[1] = 'H';
            letters[2] = 'I';
            return letters;
         case 5:
            letters[0] = 'J'; 
            letters[1] = 'K';
            letters[2] = 'L';
            return letters;
         case 6:
            letters[0] = 'M'; 
            letters[1] = 'N';
            letters[2] = 'O';
            return letters;
         case 7:
            letters[0] = 'P'; 
            letters[1] = 'Q';
            letters[2] = 'R';
            return letters;
         case 8:
            letters[0] = 'S'; 
            letters[1] = 'T';
            letters[2] = 'U';
            return letters;
         case 9:
            letters[0] = 'V'; 
            letters[1] = 'W';
            letters[2] = 'X';
            return letters;
         default:
            return letters;
      }
   }
   
   
   private static void printWords(int phoneNumber){
      String[] words = generateWords(phoneNumber);
      try(Formatter output = new Formatter("words.txt")){
         for(String word: words){
            output.format("%s%n", word);
         }
      }
      catch(SecurityException | FileNotFoundException | FormatterClosedException e){
         e.printStackTrace();
      }
   }
}