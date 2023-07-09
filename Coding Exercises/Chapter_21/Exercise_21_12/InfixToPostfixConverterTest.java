package Exercise_21_12;

import Exercise_21_12.InfixToPostfixConverter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InfixToPostfixConverterTest {

    @Test
    void convertToPostfix() {
        assertEquals("6 2 + 5 * 8 4 / -", InfixToPostfixConverter.convertToPostfix("(6 + 2) * 5 - 8 / 4"));
        assertEquals("6 3 % 2 + 5 2 ^ * 8 4 / -", InfixToPostfixConverter.convertToPostfix("(6%3 + 2) * 5^2 - 8 / 4"));
    }
}