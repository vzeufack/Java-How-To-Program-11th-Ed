import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class CheckProtectionTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

   @Test public void getCheckProtectedAmountTest() {
      Assert.assertEquals(CheckProtection.getCheckProtectedAmount("1230.60"), "**1230.60");
      Assert.assertEquals(CheckProtection.getCheckProtectedAmount("251230.60"), "251230.60");
      Assert.assertEquals(CheckProtection.getCheckProtectedAmount("1"), "********1");
      assertThrows(IllegalArgumentException.class, () -> {
        CheckProtection.getCheckProtectedAmount("1230.60a");
      });
      assertThrows(IllegalArgumentException.class, () -> {
        CheckProtection.getCheckProtectedAmount("12309999999.60");
      });
      assertThrows(IllegalArgumentException.class, () -> {
        CheckProtection.getCheckProtectedAmount("");
      });
   }
}
