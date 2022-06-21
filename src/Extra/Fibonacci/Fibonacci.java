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
            for (int i = 1; i <= number - 2; i++) {
                temp = first;
                first += second;
                second = temp;
            }
            System.out.println(first + second);
        }
    }
}
