import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class MetricConverterTest {
   @Test public void convertTest() {
      Assert.assertEquals(MetricConverter.answer("How many millimeters are in 10 kilometer// s?"), "10000000.00 millimeters");
      Assert.assertEquals(MetricConverter.answer("How many centimeters are in 0.1 meters?"), "10.00 centimeters");
      Assert.assertEquals(MetricConverter.answer("How many meters are in 17.5 hectometers?"), "1750.00 meters");
      
      Assert.assertEquals(MetricConverter.answer("How many yards are in 17.5 miles?"), "30800.00 yards");
      Assert.assertEquals(MetricConverter.answer("How many feet are in 2 inches?"), "0.17 feet");
      Assert.assertEquals(MetricConverter.answer("How many inches are in 5.5 yards?"), "198.00 inches");
      
      Assert.assertEquals("118.87 centimeters", MetricConverter.answer("How many centimeters are in 1.3 yards?"));
      Assert.assertEquals("6.21 miles", MetricConverter.answer("How many miles are in 10 kilometers?"));
   }
}
