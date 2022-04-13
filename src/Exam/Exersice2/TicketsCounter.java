package Exam.Exersice2;

public class TicketsCounter {
    public static void main(String[] args) {
        int number = 0;
        String str;
        for (int i = 1; i < 100_000; i++) {
            str = Integer.toString(i);
            if (str.contains("4") || str.contains("13")) {
                number++;
            }
        }
        System.out.println("Нужно будет исключить " + number + " номеров");
    }
}
