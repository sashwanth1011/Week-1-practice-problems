import java.util.Scanner;

public class PalindromeChecker {

    // Approach 1: Iterative Comparison
    public static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Approach 2: Recursive Comparison
    public static boolean isPalindromeRecursive(String text) {
        // Base case: strings of length 0 or 1 are palindromes
        if (text.length() <= 1) {
            return true;
        }
        // If first and last characters don't match, it's not a palindrome
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        // Recursively check the substring excluding the first and last characters
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    // Approach 3: Array Reversal Comparison
    public static boolean isPalindromeArrayReversal(String text) {
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        String reversedString = new String(reversed);
        return text.equals(reversedString);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        boolean iterativeResult = isPalindromeIterative(input);
        boolean recursiveResult = isPalindromeRecursive(input);
        boolean arrayReversalResult = isPalindromeArrayReversal(input);

        String iterativeStr = iterativeResult ? "Palindrome" : "Not Palindrome";
        String recursiveStr = recursiveResult ? "Palindrome" : "Not Palindrome";
        String arrayReversalStr = arrayReversalResult ? "Palindrome" : "Not Palindrome";

        System.out.println("Iterative: " + iterativeStr + " | Recursive: " + recursiveStr + " | Array Reversal: " + arrayReversalStr);

        scanner.close();
    }
}