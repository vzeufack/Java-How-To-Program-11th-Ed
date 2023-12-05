// Fig. 17.22: StreamOfLines.java
// Counting word occurrences in a text file.
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StreamOfLines {
   public static void main(String[] args)  throws IOException{
       Instant sequentialStart = Instant.now();
       sequentialProcessing();
       Instant sequentialEnd = Instant.now();
       System.out.printf("Sequential duration: %d%n%n", Duration.between(sequentialStart, sequentialEnd).toMillis());

       Instant parallelStart = Instant.now();
       parallelProcessing();
       Instant parallelEnd = Instant.now();
       System.out.printf("Parallel duration: %d%n%n", Duration.between(parallelStart, parallelEnd).toMillis());

   }

   private static void parallelProcessing() throws IOException{
       // Regex that matches one or more consecutive whitespace characters
       Pattern pattern = Pattern.compile("\\s+");

       // count occurrences of each word in a Stream<String> sorted by word
       Map<String, Long> wordCounts =
               Files.lines(Paths.get("Chapter2Paragraph.txt")).parallel()
                       .flatMap(pattern::splitAsStream)
                       .collect(Collectors.groupingBy(String::toLowerCase,
                               TreeMap::new, Collectors.counting()));

       // display the words grouped by starting letter
       wordCounts.entrySet()
               .stream().parallel()
               .collect(
                       Collectors.groupingBy(entry -> entry.getKey().charAt(0),
                               TreeMap::new, Collectors.toList()))
               .forEach((letter, wordList) -> {
                   System.out.printf("%n%C%n", letter);
                   wordList.stream().forEach(word -> System.out.printf(
                           "%13s: %d%n", word.getKey(), word.getValue()));
               });
   }

   private static void sequentialProcessing() throws IOException{
       // Regex that matches one or more consecutive whitespace characters
       Pattern pattern = Pattern.compile("\\s+");

       // count occurrences of each word in a Stream<String> sorted by word
       Map<String, Long> wordCounts =
               Files.lines(Paths.get("Chapter2Paragraph.txt"))
                       .flatMap(pattern::splitAsStream)
                       .collect(Collectors.groupingBy(String::toLowerCase,
                               TreeMap::new, Collectors.counting()));

       // display the words grouped by starting letter
       wordCounts.entrySet()
               .stream()
               .collect(
                       Collectors.groupingBy(entry -> entry.getKey().charAt(0),
                               TreeMap::new, Collectors.toList()))
               .forEach((letter, wordList) -> {
                   System.out.printf("%n%C%n", letter);
                   wordList.stream().forEach(word -> System.out.printf(
                           "%13s: %d%n", word.getKey(), word.getValue()));
               });
   }
} 


/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
