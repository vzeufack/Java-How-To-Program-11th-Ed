import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class MorseCodeTest {
   @Test public void convertEnglishToMorseCodeTest() {
      Assert.assertEquals(MorseCode.toMorseCode("Argentina will win World Cup 2022", ".- .-. --. . -. - .. -. .-   .-- -- .-.. .-..   .-- .. -.   .-- --- .-. .-.. -..   -.-. ..- .--.   ..--- ----- ..--- ..---"));
   }
}
