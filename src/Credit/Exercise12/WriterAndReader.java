package Credit.Exercise12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WriterAndReader {

    public static void main(String[] args) {

        try (FileWriter fileWriter = new FileWriter("test.txt")) {
            fileWriter.write("""
                    "Интересно, в чем придет профессор на лекцию в этот раз?" - думала Марина Рубинова. Профессор пришел в тренировочном костюме и в кедах.
                    Он был суров и деловит. Он сразу спросил:
                    - Где батут, Марина?
                    - Тут! - сразу ответила она.
                    И профессор стал прыгать. А телевизионная бригада в студии готовилась к передаче: выставляла свет, прогревала аппаратуру.
                    Наверное, летать над батутом трудно. Профессор все время переворачивался в воздухе и норовил опуститься в сетку головой,
                    и на его лице проступали мелкие квадраты от сетки.""");
        } catch (Exception e) {
            e.printStackTrace();
        }

        StringBuilder readingText = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("test.txt"))) {
            String result = bufferedReader.readLine();
            while (result != null) {
                readingText.append(result);
                result = bufferedReader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //считаем слова в тексте

        int countWords = 0;
        Pattern pattern = Pattern.compile("[a-zA-Zа-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(readingText);
        while (matcher.find()) {
            countWords++;
        }

        // для поиска знаков препинания я воспользовалась готовым решением из доп.задания №8

        int countPunctuations = 0;
        pattern = Pattern.compile("[,!?:;]");
        matcher = pattern.matcher(readingText);
        while (matcher.find()) {
            countPunctuations++;
        }
        pattern = Pattern.compile("\\.{3}");
        matcher = pattern.matcher(readingText);
        while (matcher.find()) {
            countPunctuations++;
        }
        pattern = Pattern.compile("[^.]\\.[^.]");
        matcher = pattern.matcher(readingText);
        while (matcher.find()) {
            countPunctuations++;
        }
        pattern = Pattern.compile("[^.]\\.$");
        matcher = pattern.matcher(readingText);
        while (matcher.find()) {
            countPunctuations++;
        }
        pattern = Pattern.compile("\"+[^\"]+\"");
        matcher = pattern.matcher(readingText);
        while (matcher.find()) {
            countPunctuations++;
        }
        pattern = Pattern.compile("\\(+[^(]+\\)");
        matcher = pattern.matcher(readingText);
        while (matcher.find()) {
            countPunctuations++;
        }
        pattern = Pattern.compile("-+\s");
        matcher = pattern.matcher(readingText);
        while (matcher.find()) {
            countPunctuations++;
        }

        System.out.printf("В прочитанном тексте %d слов и %d знаков препинания.", countWords, countPunctuations);
    }
}
