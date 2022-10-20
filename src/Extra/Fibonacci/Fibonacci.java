package Extra.Fibonacci;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("Enter the number:");

        Scanner scanner = new Scanner(System.in);
        long number = scanner.nextLong();

        long first = 0, second = 1, fib;

        if (number == 0 || number == 1) {
            fib = number;
        } else {
            long temp;
            for (int i = 2; i < number; i++) {
                temp = second;
                second += first;
                first = temp;
            }
            fib = first + second;
        }
        System.out.println("Fibonacci's number:\n" + fib);
    }
}
