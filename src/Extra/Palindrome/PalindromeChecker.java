package Extra.Palindrome;

import java.util.Locale;

public class PalindromeChecker {
    public static void main(String[] args) {
        String[] words = {"Madam i’m Adam", "Palindrome", "Olson in Oslo", "1234512345", "123454321", "1234554321"};
        for (String word: words) {
            System.out.println("Is the word \"" + word + "\" palindrome? - " + checkPalindrome(word));
        }
    }

    private static String checkPalindrome(String word){
        String palindrome = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(Locale.ROOT);
        String reversed = new StringBuilder(palindrome).reverse().toString();
        return palindrome.equals(reversed) ? "yes" : "no";
    }
}