import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.Optional;

public class FirstNPrimes{
   public static void main(String[] args){
      Scanner input = new Scanner(System.in);
      System.out.printf("Enter the number of primes > ");
      int n = input.nextInt();

      IntStream.iterate(2, x -> x + 1)
               .filter(x -> isPrime(x))
               .limit(n)
               .forEach(System.out::println);
   }

   private static boolean isPrime(int n){
      Optional<Integer> firstMultiple = IntStream.rangeClosed(2, (int)Math.sqrt(n))
                                                 .boxed()
                                                 .filter(x -> n%x == 0)
                                                 .findFirst();

      return !firstMultiple.isPresent();
   }
}