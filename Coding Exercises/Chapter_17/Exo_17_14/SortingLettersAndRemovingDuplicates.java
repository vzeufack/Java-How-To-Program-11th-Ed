import java.security.SecureRandom;
import java.util.stream.Collectors;
import java.util.List;
import java.util.stream.Stream;
import java.util.Comparator;

public class SortingLettersAndRemovingDuplicates{
   public static void main(String[] args){
      SecureRandom random = new SecureRandom();
      List<Character> letters = Stream.generate(() -> 65 + random.nextInt(26))
                              		  .map(x -> Character.toChars(x)[0])
                              		  .limit(30)
                              		  .collect(Collectors.toList());
      System.out.println(letters);
      
      List<Character> sortedLetters = 
         letters.stream()
                .sorted()
                .collect(Collectors.toList());
      System.out.println(sortedLetters);
      
      List<Character> sortedLettersDescending = 
         letters.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
      System.out.println(sortedLettersDescending);
      
      letters.stream()
             .distinct()
             .sorted()
             .forEach(c -> System.out.printf("%s ", c));
   }
}