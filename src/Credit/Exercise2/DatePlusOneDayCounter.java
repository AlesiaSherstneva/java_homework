package Credit.Exercise2;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class DatePlusOneDayCounter {
    public static void main(String[] args) {
        GregorianCalendar calendar = new GregorianCalendar();
        Scanner scanner = new Scanner(System.in);

        //немножко читерское рещение :-)

        System.out.print("Введите день: ");
        calendar.set(Calendar.DAY_OF_MONTH, scanner.nextInt());
        System.out.print("Введите месяц: ");
        calendar.set(Calendar.MONTH, scanner.nextInt() - 1);
        System.out.print("Введите год: ");
        calendar.set(Calendar.YEAR, scanner.nextInt());

        calendar.add(Calendar.DAY_OF_MONTH, +1);

        System.out.print("Следующий день: "
                + calendar.get(Calendar.DAY_OF_MONTH) + " "
                + (calendar.get(Calendar.MONTH) + 1) + " "
                + calendar.get(Calendar.YEAR));
    }
}
