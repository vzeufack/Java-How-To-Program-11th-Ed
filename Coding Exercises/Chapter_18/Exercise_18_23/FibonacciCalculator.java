// Fig. 18.5: FibonacciCalculator.java
// Recursive fibonacci method.
import java.math.BigInteger;

public class FibonacciCalculator {
    private static BigInteger TWO = BigInteger.valueOf(2);
    private static long numOfCalls = 0L;

    // recursive declaration of method fibonacci
    public static BigInteger fibonacci(BigInteger number) {
        numOfCalls++;
        if (number.equals(BigInteger.ZERO) ||
                number.equals(BigInteger.ONE)) { // base cases
            return number;
        }
        else { // recursion step
            return fibonacci(number.subtract(BigInteger.ONE)).add(
                    fibonacci(number.subtract(TWO)));
        }

    }

    public static void main(String[] args) {
        // displays the fibonacci values from 0-40
        for (int counter = 0; counter <= 40; counter++) {
            numOfCalls = 0L;
            long startTime = System.currentTimeMillis();
            BigInteger result = fibonacci(BigInteger.valueOf(counter));
            long endTime = System.currentTimeMillis();
            System.out.printf("Fibonacci of %d is: %d | %d call(s) in %d ms%n", counter, result, numOfCalls, endTime - startTime);
        }
    }
}


/*************************************************************************
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
