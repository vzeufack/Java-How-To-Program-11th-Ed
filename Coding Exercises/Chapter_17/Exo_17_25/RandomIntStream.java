import java.security.SecureRandom;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.time.Instant;
import java.time.Duration;
import java.util.Random;

public class RandomIntStream {
    public static void main(String[] args) {
        Instant startInstant = Instant.now();
        SecureRandom random = new SecureRandom();

        // roll a die 60,000,000 times and summarize the results
        System.out.printf("%-6s%s%n", "Face", "Frequency");
        random.ints(60_000_000, 1, 7)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()))
                .forEach((face, frequency) ->
                        System.out.printf("%-6d%d%n", face, frequency));
        Instant endInstant = Instant.now();
        Duration duration = Duration.between(startInstant, endInstant);
        System.out.println("Duration = " + duration.toMillis());
    }
}
