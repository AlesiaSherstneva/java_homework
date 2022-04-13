package Exam.Exercise3;

public class TicketsCounter {
    public static void main(String[] args) {
        int number1, number2, number3, number4, number5, number6;
        int counter = 0;
        for (int i = 1; i < 1_000_000; i++) {
            number1 = i % 10;
            number2 = i / 10 % 10;
            number3 = i / 100 % 10;
            number4 = i / 1_000 % 10;
            number5 = i / 10_000 % 10;
            number6 = i / 100_000 % 10;
            if (number1 + number2 + number3 == number4 + number5 + number6) {
                counter++;
            }
        }
        System.out.println("В одном рулоне " + counter + " счастливых билетов");
    }
}
