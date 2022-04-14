package Credit.Exercise8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PunctuationCounter {

    public static void main(String[] args) {

        /* Если верить учебнику по русскому языку за 4 класс, в русском языке существует 10 знаков препинания.
        В тестовой строке я использовала их все хотя бы по одному разу.*/

        String str = "Не очень умею я, конечно, со строками работать - с цифрами как-то проще; но надо когда-то начинать." +
                " Не так ли? Иначе не быть мне \"программистом\" (останусь на почте до пенсии...), поэтому: " +
                "учиться, учиться, и ещё раз учиться, как завещал великий Ленин! " +
                "Последняя фраза - для проверки точки в конце строки.";
        int counter = 0;

        /* сначала находим всё, что состоит из одного символа: запятые, восклицательные и вопросительные знаки,
        двоеточия, точки с запятой */

        Pattern pattern = Pattern.compile("[,!?:;]");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            counter++;
        }

        // находим многоточия: три точки подряд

        pattern = Pattern.compile("\\.{3}");
        matcher = pattern.matcher(str);
        while (matcher.find()) {
            counter++;
        }

        // ищем точки, отделяем их от многоточий: слева и справа должны быть не точки

        pattern = Pattern.compile("[^.]\\.[^.]");
        matcher = pattern.matcher(str);
        while (matcher.find()) {
            counter++;
        }

        // шаблон для точки в конце строки пришлось создать отдельно, иначе не получалось отделить её от многоточия

        pattern = Pattern.compile("[^.]\\.$");
        matcher = pattern.matcher(str);
        while (matcher.find()) {
            counter++;
        }

        // ищем кавычки: между ними может быть любое количество символов

        pattern = Pattern.compile("\"+[^\"]+\"");
        matcher = pattern.matcher(str);
        while (matcher.find()) {
            counter++;
        }

        // ищем скобки: та же история, что и с кавычками

        pattern = Pattern.compile("\\(+[^(]+\\)");
        matcher = pattern.matcher(str);
        while (matcher.find()) {
            counter++;
        }

        // ищем тире: слева и справа должны быть пробелы, иначе это дефис, а не тире

        pattern = Pattern.compile("\s+-+\s");
        matcher = pattern.matcher(str);
        while (matcher.find()) {
            counter++;
        }

        System.out.println("В заданном предложении " + counter + " знаков препинания.");
    }
}
