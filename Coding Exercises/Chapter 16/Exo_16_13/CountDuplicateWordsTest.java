import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;


public class CountDuplicateWordsTest {
   String sentence1, sentence2, sentence3;
   HashMap<String, Integer> expectedWordCount1, expectedWordCount2, expectedWordCount3;
  

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
      sentence1 = "";
      sentence2 = "I love the java programming language. So much love!";
      sentence3 = "   I love the!! --- java54 programming88 language. So much love!" + 
                          " i love the# java$ programming language. so much love! ";
      
      expectedWordCount1 = new HashMap<>();
      
      expectedWordCount2 = new HashMap<>();
      expectedWordCount2.put("i", 1);
      expectedWordCount2.put("love", 2);
      expectedWordCount2.put("the", 1);
      expectedWordCount2.put("java", 1);
      expectedWordCount2.put("programming", 1);
      expectedWordCount2.put("language", 1);
      expectedWordCount2.put("so", 1);
      expectedWordCount2.put("much", 1);
      
      expectedWordCount3 = new HashMap<>();
      expectedWordCount3.put("i", 2);
      expectedWordCount3.put("love", 4);
      expectedWordCount3.put("the", 2);
      expectedWordCount3.put("java", 2);
      expectedWordCount3.put("programming", 2);
      expectedWordCount3.put("language", 2);
      expectedWordCount3.put("so", 2);
      expectedWordCount3.put("much", 2);      
   }
   
   /**
     * Test countDuplicate
     */
   @Test public void countDuplicateTest(){
      Assert.assertEquals(0, CountDuplicateWords.countDuplicates(sentence1));
      Assert.assertEquals(1, CountDuplicateWords.countDuplicates(sentence2));
      Assert.assertEquals(8, CountDuplicateWords.countDuplicates(sentence3));
   }
   
   /**
     * Test countWords
     */
   @Test public void countWordsTest(){
      assertEquals(expectedWordCount1, CountDuplicateWords.countWords(sentence1));
      assertEquals(expectedWordCount2, CountDuplicateWords.countWords(sentence2));
      assertEquals(expectedWordCount3, CountDuplicateWords.countWords(sentence3));
   }
}
