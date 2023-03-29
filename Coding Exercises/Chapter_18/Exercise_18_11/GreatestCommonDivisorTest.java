import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreatestCommonDivisorTest {
    @Test
    public void gcdTest(){
        assertEquals(10, GreatestCommonDivisor.gcd(0, 10));
        assertEquals(6, GreatestCommonDivisor.gcd(54, 24));
        assertEquals(1, GreatestCommonDivisor.gcd(3, 4));
    }
}
