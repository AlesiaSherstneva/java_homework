package Credit.Exercise4;

import java.util.Scanner;

/* Число является простым, если делится без остатка только на само себя и на единицу. Решение задачи
заключается в расчёте количества делителей у введённого числа: если делителей больше двух - число простым не является. */

public class PrimeNumbersSearcher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        int number = scanner.nextInt(), counter = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                counter++;
            }
            if (counter > 2) {
                System.out.println("Число " + number + " не является простым");
                break;
            }
        }
        if (counter == 2) {
            System.out.println("Число " + number + " является простым");
        }
    }
}
