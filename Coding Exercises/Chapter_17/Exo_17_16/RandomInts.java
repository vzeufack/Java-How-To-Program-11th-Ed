import java.security.SecureRandom;

public class RandomInts{
   public static void main(String[] args){
      SecureRandom random = new SecureRandom();
      random.ints(50, 1, 1000)
            .filter(x -> x % 2 != 0)
            .sorted()
            .forEach(System.out::println);
   }
}