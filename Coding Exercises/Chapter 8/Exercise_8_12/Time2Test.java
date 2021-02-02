// Fig. 8.6: Time2Test.java
// Overloaded constructors used to initialize Time2 objects.

import java.util.ArrayList;

public class Time2Test {
   public static void main(String[] args) {
      Time2 t1 = new Time2(); // 00:00:00          
      Time2 t2 = new Time2(2); // 02:00:00         
      Time2 t3 = new Time2(21, 34); // 21:34:00    
      Time2 t4 = new Time2(12, 25, 42); // 12:25:42
      Time2 t5 = new Time2(t4); // 12:25:42        

      System.out.println("Constructed with:");
      displayTime("t1: all default arguments", t1);
      displayTime("t2: hour specified; default minute and second", t2);
      displayTime("t3: hour and minute specified; default second", t3);
      displayTime("t4: hour, minute and second specified", t4);
      displayTime("t5: Time2 object t4 specified", t5);

      // attempt to initialize t6 with invalid values
      try {
         Time2 t6 = new Time2(27, 74, 99); // invalid values
      } 
      catch (IllegalArgumentException e) {
         System.out.printf("%nException while initializing t6: %s%n",
            e.getMessage());
      }
      
      //Testing tick, incrementMinute and incrementHour
      System.out.println();
            
      ArrayList <Time2> testCases = new ArrayList <Time2>();
      testCases.add(t1);
      testCases.add(new Time2(13,5,59)); //increment to next minute
      testCases.add(new Time2(2,59,6)); //increment to next hour
      testCases.add(new Time2(23,4,34)); //increment to next day
      testCases.add(new Time2(23,59,59)); //increment to next second, next minute and next day
      
      test(testCases);
   } 

   // displays a Time2 object in 24-hour and 12-hour formats
   private static void displayTime(String header, Time2 t) {
      System.out.printf("%s%n   %s%n   %s%n",
         header, t.toUniversalString(), t.toString());
   } 
   
   private static void test (ArrayList <Time2> testCases){
       //for (int i = 0; i < testCases.size(); i++){
       for (Time2 testCase: testCases){
           Time2 testCaseCopy1 = new Time2(testCase);
           Time2 testCaseCopy2 = new Time2(testCase);
           Time2 testCaseCopy3 = new Time2(testCase);
           
           System.out.printf("**** Test case: %s *****\n", testCase);
           
           testCaseCopy1.tick();
           System.out.printf("After incrementing %s by 1 second we got %s\n", testCase, testCaseCopy1);
           
           testCaseCopy2.incrementMinute();
           System.out.printf("After incrementing %s by 1 minute we got %s\n", testCase, testCaseCopy2);
           
           testCaseCopy3.incrementHour();
           System.out.printf("After incrementing %s by 1 hour we got %s\n", testCase, testCaseCopy3);
           
           System.out.printf("***** End test case *****\n\n");
       }
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
