import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class MorseCodeTest {
   @Test public void convertEnglishToMorseCodeTest() {
      Assert.assertEquals(MorseCode.toMorseCode("Argentina will win World Cup 2022"), 
                          ".- .-. --. . -. - .. -. .-   .-- .. .-.. .-..   .-- .. -.   .-- --- .-. .-.. -..   -.-. ..- .--.   ..--- ----- ..--- ..---");
   }
   
   @Test public void convertMorseCodeToEnglishTest() {
      Assert.assertEquals(MorseCode.toEnglish(".- .-. --. . -. - .. -. .-   .-- .. .-.. .-..   .-- .. -.   .-- --- .-. .-.. -..   -.-. ..- .--.   ..--- ----- ..--- ..---"), 
                          "argentina will win world cup 2022");
   }
}
