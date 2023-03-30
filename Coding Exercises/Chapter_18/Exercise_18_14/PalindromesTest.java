import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromesTest {
    @Test
    public void isPalindromeTest(){
        assertTrue(Palindromes.isPalindrome("radar"));
        assertTrue(Palindromes.isPalindrome("able was i ere i saw elba"));
        assertTrue(Palindromes.isPalindrome("a man a plan a canal panama."));
        assertTrue(Palindromes.isPalindrome("a"));
        assertTrue(Palindromes.isPalindrome("44"));
        assertTrue(Palindromes.isPalindrome("44 4"));
        assertTrue(Palindromes.isPalindrome(""));
        assertFalse(Palindromes.isPalindrome("abc"));
    }
}