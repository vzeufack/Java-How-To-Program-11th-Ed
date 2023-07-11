package Exercise_21_13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostfixEvaluatorTest {
    @Test
    void evaluatePostfixExpression(){
        assertEquals(38, PostfixEvaluator.evaluatePostfixExpression(new StringBuffer("6 2 + 5 * 8 4 / -")));
        assertEquals(48, PostfixEvaluator.evaluatePostfixExpression(new StringBuffer("6 3 % 2 + 5 2 ^ * 8 4 / -")));
        assertEquals(53, PostfixEvaluator.evaluatePostfixExpression(new StringBuffer("1 10 + 5 * 8 4 / -")));
        assertEquals(26, PostfixEvaluator.evaluatePostfixExpression(new StringBuffer("15 31 + 20 -")));
    }
}