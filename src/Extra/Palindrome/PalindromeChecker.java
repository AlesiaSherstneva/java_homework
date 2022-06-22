package Extra.Palindrome;

import java.util.Locale;

public class PalindromeChecker {
    public static void main(String[] args) {
        String[] words = {"Madam i’m Adam", "Palindrome", "Olson in Oslo", "1234512345", "123454321", "1234554321"};
        PalindromeChecker checker = new PalindromeChecker();
        for (String word: words) {
            System.out.println("Is the word \"" + word + "\" palindrome? - " + checker.checkPalindrome(word));
        }
    }

    String checkPalindrome(String word){
        String palindrome = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(Locale.ROOT);
        StringBuilder second = new StringBuilder()
                .append(palindrome.substring((palindrome.length() / 2) + (palindrome.length() % 2 == 0 ? 0 : 1)))
                .reverse();
        return palindrome.substring(0, palindrome.length() / 2).equals(second.toString()) ? "yes" : "no";
    }
}
