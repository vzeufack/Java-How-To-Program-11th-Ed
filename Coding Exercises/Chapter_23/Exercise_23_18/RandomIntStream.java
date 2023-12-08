import java.security.SecureRandom;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.time.Instant;
import java.time.Duration;
import java.util.Random;

public class RandomIntStream {
    public static void main(String[] args) {
        // roll a die 60,000,000 times and summarize the results with parallel streams
        Instant startInstantParallel = Instant.now();
        SecureRandom randomSequential = new SecureRandom();
        System.out.printf("%-6s%s%n", "Face", "Frequency");
        randomSequential.ints(60_000_000, 1, 7).parallel()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()))
                .forEach((face, frequency) ->
                        System.out.printf("%-6d%d%n", face, frequency));
        Instant endInstantParallel = Instant.now();
        Duration durationParallel = Duration.between(startInstantParallel, endInstantParallel);
        System.out.println("Duration parallel = " + durationParallel.toMillis() + "\n\n");

        // roll a die 60,000,000 times and summarize the results with sequential streams
        Instant startInstantSequential = Instant.now();
        SecureRandom randomParallel = new SecureRandom();
        System.out.printf("%-6s%s%n", "Face", "Frequency");
        randomParallel.ints(60_000_000, 1, 7)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()))
                .forEach((face, frequency) ->
                        System.out.printf("%-6d%d%n", face, frequency));
        Instant endInstantSequential = Instant.now();
        Duration durationSequential = Duration.between(startInstantSequential, endInstantSequential);
        System.out.println("Duration sequential = " + durationSequential.toMillis() + "\n\n");
    }
}
