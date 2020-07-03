import org.junit.Test;

import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("0"));
        assertTrue(palindrome.isPalindrome("121"));
        assertTrue(palindrome.isPalindrome("1221"));
        assertFalse(palindrome.isPalindrome("1234532"));
        assertFalse(palindrome.isPalindrome("12"));
    }

    @Test
    public void testOffByOnePalindrome() {
        OffByOne offByOne = new OffByOne();
        assertTrue(palindrome.isPalindrome("ab", offByOne));
        assertTrue(palindrome.isPalindrome("cbb", offByOne));
        assertTrue(palindrome.isPalindrome("", offByOne));
        assertFalse(palindrome.isPalindrome("aa", offByOne));
    }
}
