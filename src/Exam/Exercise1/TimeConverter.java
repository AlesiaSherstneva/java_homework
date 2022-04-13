package Exam.Exercise1;

import java.util.Scanner;

public class TimeConverter {
    public static void main(String[] args) {
        System.out.print("Введите промежуток времени в секундах: ");
        Scanner scanner = new Scanner(System.in);
        int time = scanner.nextInt();

        int week, day, hour, min;
        hour = time / (60 * 60);
        time -= hour * (60 * 60);
        min = time / 60;
        time -= min * 60;

        if (min == 0 && hour == 0) {
            System.out.println(seconds(time));
        } else if (min > 0 && hour == 0) {
            System.out.println(minutes(min) + seconds(time));
        } else {
            System.out.println(hours(hour) + minutes(min) + seconds(time));
        }

        day = hour / 24;
        week = hour / (7 * 24);
        hour -= day * 24;

        if (day > 0 && week == 0) {
            System.out.println(days(day) + hours(hour) + minutes(min) + seconds(time));
        } else if (week > 0) {
            day -= week * 7;
            if (day == 0) {
                System.out.println(weeks(week) + hours(hour) + minutes(min) + seconds(time));
            } else {
                System.out.println(weeks(week) + days(day) + hours(hour) + minutes(min) + seconds(time));
            }
        }
    }

    // так как числовые значения времени в дальнейшем нигде не используются, я оформила вывод в формате строки

    public static String seconds(int n) {
        String sec;
        if (n % 10 == 1 && n % 100 != 11) {
            sec = n + " секунда ";
        } else if ((n % 10 == 2 && n % 100 != 12)
                || (n % 10 == 3 && n % 100 != 13)
                || (n % 10 == 4 && n % 100 != 14)) {
            sec = n + " секунды ";
        } else {
            sec = n + " секунд ";
        }
        return sec;
    }

    public static String minutes(int n) {
        String min;
        if (n % 10 == 1 && n % 100 != 11) {
            min = n + " минута ";
        } else if ((n % 10 == 2 && n % 100 != 12)
                || (n % 10 == 3 && n % 100 != 13)
                || (n % 10 == 4 && n % 100 != 14)) {
            min = n + " минуты ";
        } else {
            min = n + " минут ";
        }
        return min;
    }

    public static String hours(int n) {
        String hour;
        if (n % 10 == 1 && n % 100 != 11) {
            hour = n + " час ";
        } else if ((n % 10 == 2 && n % 100 != 12)
                || (n % 10 == 3 && n % 100 != 13)
                || (n % 10 == 4 && n % 100 != 14)) {
            hour = n + " часа ";
        } else {
            hour = n + " часов ";
        }
        return hour;
    }

    public static String days(int n) {
        String day;
        if (n % 10 == 1 && n % 100 != 11) {
            day = n + " сутки ";
        } else {
            day = n + " суток ";
        }
        return day;
    }

    public static String weeks(int n) {
        String week;
        if (n % 10 == 1 && n % 100 != 11) {
            week = n + " неделя ";
        } else if ((n % 10 == 2 && n % 100 != 12)
                || (n % 10 == 3 && n % 100 != 13)
                || (n % 10 == 4 && n % 100 != 14)) {
            week = n + " недели ";
        } else {
            week = n + " недель ";
        }
        return week;
    }
}
