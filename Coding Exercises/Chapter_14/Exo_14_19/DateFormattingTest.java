import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class DateFormattingTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

   @Test public void formatTest() {
      Assert.assertEquals(DateFormatting.format("04/25/1995"), "April 25, 1995");
      assertThrows(IllegalArgumentException.class, () -> {
        DateFormatting.format("0425/1995");
      });
   }
   
   @Test public void isValidFormatTest() {
      Assert.assertEquals(DateFormatting.isValidFormat("04/25/1995"), true);
      Assert.assertEquals(DateFormatting.isValidFormat("04 /25/1995"), false);
      Assert.assertEquals(DateFormatting.isValidFormat("13/25/1995"), false);
      Assert.assertEquals(DateFormatting.isValidFormat("4/25/1995"), false);
      Assert.assertEquals(DateFormatting.isValidFormat("04/32/1995"), false);
      Assert.assertEquals(DateFormatting.isValidFormat("02/29/2000"), false);
      Assert.assertEquals(DateFormatting.isValidFormat("02/28/2000"), true);
      Assert.assertEquals(DateFormatting.isValidFormat("04 25 1995"), false);
   }
}
