public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> deque = wordToDeque(word);
        if (deque.size() <= 1) {
            return true;
        }
        return isPalindrome(deque.removeFirst(), deque.removeLast(), deque);
    }

    private boolean isPalindrome(char a, char b, Deque<Character> deque) {
        if (a != b) {
            return false;
        }

        if (deque.size() <= 1) {
            return true;
        }

        return isPalindrome(deque.removeFirst(), deque.removeLast(), deque);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> deque = wordToDeque(word);
        if (deque.size() <= 1) {
            return true;
        }
        return isPalindrome(deque.removeFirst(), deque.removeLast(), deque, cc);
    }

    private boolean isPalindrome(char a, char b, Deque<Character> deque, CharacterComparator cc) {
        if (!cc.equalChars(a, b)) {
            return false;
        }

        if (deque.size() <= 1) {
            return true;
        }

        return isPalindrome(deque.removeFirst(), deque.removeLast(), deque, cc);
    }
}
