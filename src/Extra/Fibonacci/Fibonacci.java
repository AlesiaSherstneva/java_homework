package Extra.Fibonacci;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.print("Enter the number: ");

        Scanner scanner = new Scanner(System.in);
        long number = scanner.nextLong();

        long first = 0, second = 1, temp;

        if (number == 0) {
            System.out.println(first);
        } else if (number == 1) {
            System.out.println(second);
        } else {
            for (int i = 2; i < number; i++) {
                temp = second;
                second += first;
                first = temp;
            }
            System.out.println(first + second);
        }
    }
}
