import java.util.stream.IntStream;

public class StreamMapReduce {
   public static void main(String[] args){
      System.out.println(
         IntStream.rangeClosed(1, 10)
                  .map(x -> {return x % 2 == 0 ? x * 3: 0;})
                  .sum());
   }
}