import java.util.stream.IntStream;

public class StreamFilterMapReduce{
   public static void main(String[] args){
      System.out.println(
         IntStream.rangeClosed(1, 10)
                  .map(
                     x -> {
                        System.out.println("\nmap: " + x);
                        return x * 3;
                     })
                  .filter(
                     x -> {
                        System.out.printf("filter: %d%n", x);
                        return x % 2 == 0;
                     })
                  .sum());
   }
}