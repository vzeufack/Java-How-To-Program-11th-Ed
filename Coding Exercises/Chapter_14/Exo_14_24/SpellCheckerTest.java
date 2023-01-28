import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class SpellCheckerTest {
   @Test public void levenshteinDistanceTest() {
      Assert.assertEquals(3, SpellChecker.levenshteinDistance("horse", "ros"));
      Assert.assertEquals(5, SpellChecker.levenshteinDistance("intention", "execution"));
      Assert.assertEquals(3, SpellChecker.levenshteinDistance("abcdef", "azced"));
   }
}
