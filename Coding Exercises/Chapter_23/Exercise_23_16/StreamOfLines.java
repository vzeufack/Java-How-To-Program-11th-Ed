// Fig. 17.22: StreamOfLines.java
// Counting word occurrences in a text file.
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StreamOfLines {
   public static void main(String[] args) throws IOException {
       Path path = Paths.get("Chapter2Paragraph.txt");

       Instant sequentialStart = Instant.now();
       Files.lines(path)
              .map(line -> line.chars())
              .flatMap(c -> c.mapToObj(n -> (char)n))
              .collect(Collectors.groupingBy(Character::toLowerCase,
                 TreeMap::new, Collectors.counting()))
              .forEach((character, count) -> {
                 System.out.printf("%s -> %d\n", character, count);
              });
       Instant sequentialEnd = Instant.now();
       System.out.printf("Sequential duration: %d%n%n", Duration.between(sequentialStart, sequentialEnd).toMillis());

       Instant parallelStart = Instant.now();
       Files.lines(path).parallel()
               .map(line -> line.chars())
               .flatMap(c -> c.mapToObj(n -> (char)n))
               .collect(Collectors.groupingBy(Character::toLowerCase,
                       TreeMap::new, Collectors.counting()))
               .forEach((character, count) -> {
                   System.out.printf("%s -> %d\n", character, count);
               });
       Instant parallelEnd = Instant.now();
       System.out.printf("Parallel duration: %d%n%n", Duration.between(parallelStart, parallelEnd).toMillis());
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
