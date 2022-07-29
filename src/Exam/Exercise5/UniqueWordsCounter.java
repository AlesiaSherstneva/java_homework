package Exam.Exercise5;

import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UniqueWordsCounter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String str = scanner.nextLine();
        Set<String> words = new HashSet<>();

        Pattern pattern = Pattern.compile("\\S[\\w]*\\b");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            words.add(str.substring(matcher.start(), matcher.end()).toLowerCase(Locale.ROOT));
        }

        System.out.printf("Во введённой строке %d уникальных слов", words.size());
    }
}
