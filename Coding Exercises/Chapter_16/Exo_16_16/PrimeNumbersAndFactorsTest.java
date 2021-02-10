import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class PrimeNumbersAndFactorsTest {
   Integer[] testCases = {0,1,2,3,10,12,54,10000,991};

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

   @Test public void getPrimeFactorsTest() {      
      Integer[][] primeFactorsArray = {null,null,{},{},{2,5},{2,3},{2,3},{2,5},{}};
      
      for (int i = 0; i < testCases.length; i++){
         if (primeFactorsArray[i] != null){
            Set<Integer> primeFactors = new HashSet<>(Arrays.asList(primeFactorsArray[i]));
            Assert.assertEquals(primeFactors, PrimeNumbersAndFactors.getPrimeFactors(testCases[i]));
         }
         else{
            Assert.assertTrue(null == PrimeNumbersAndFactors.getPrimeFactors(testCases[i]));
         }
      }      
   }
   
   @Test public void isPrimeTest(){
      boolean[] expected = {false, false, true, true, false, false, false, false, true};
      for (int i = 0; i < testCases.length; i++){
         assertTrue(expected[i] == PrimeNumbersAndFactors.isPrime(testCases[i]));
      }
   }
}
