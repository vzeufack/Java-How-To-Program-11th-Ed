// Fig. 17.22: StreamOfLines.java
// Counting word occurrences in a text file.
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StreamOfLines {
   public static void main(String[] args) throws IOException {
      // Regex that matches one or more consecutive whitespace characters
      //Pattern pattern = Pattern.compile(""); 

      // count occurrences of each word in a Stream<String> sorted by word
      //Map<String, Long> wordCounts =                             
         // Files.lines(Paths.get("Chapter2Paragraph.txt"))         
//               .flatMap(pattern::splitAsStream)      
//               .collect(Collectors.groupingBy(String::toLowerCase,
//                  TreeMap::new, Collectors.counting()))
//               .forEach((character, count) -> {
//                  System.out.printf("%s -> %d\n", character, count);
//               });
         
         Files.lines(Paths.get("Chapter2Paragraph.txt"))         
              .map(line -> line.chars())
              .flatMap(c -> c.mapToObj(n -> (char)n))
              .collect(Collectors.groupingBy(Character::toLowerCase,
                 TreeMap::new, Collectors.counting()))
              .forEach((character, count) -> {
                 System.out.printf("%s -> %d\n", character, count);
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
