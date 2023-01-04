import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class CheckAmountToWordTest {
   @Test public void convertTest() {
      Assert.assertEquals(CheckAmountToWord.convert(987.00), "nine hundred and eighty seven");
      Assert.assertEquals(CheckAmountToWord.convert(112.43), "one hundred twelve and 43/100");
      Assert.assertEquals(CheckAmountToWord.convert(0), "zero");
      Assert.assertEquals(CheckAmountToWord.convert(110), "one hundred and ten");
      Assert.assertEquals(CheckAmountToWord.convert(100), "one hundred");
      Assert.assertEquals(CheckAmountToWord.convert(108), "one hundred and eight");
      Assert.assertEquals(CheckAmountToWord.convert(108.05), "one hundred eight and 5/100");
      Assert.assertEquals(CheckAmountToWord.convert(999.99), "nine hundred ninety nine and 99/100");
      Assert.assertEquals(CheckAmountToWord.convert(17.1), "seventeen and 1/10");
      Assert.assertEquals(CheckAmountToWord.convert(617.1), "six hundred seventeen and 1/10");
      Assert.assertEquals(CheckAmountToWord.convert(4), "four");
      Assert.assertEquals(CheckAmountToWord.convert(5.7), "five and 7/10");
   }
}
