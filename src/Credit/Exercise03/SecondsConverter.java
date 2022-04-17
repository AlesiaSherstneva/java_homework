package Credit.Exercise03;

public class SecondsConverter {
    public static void main(String[] args) {
        int n = (int) (Math.random() * 28800);
        System.out.println(n);
        if (n != 0) {
            switch (n / 3600) {
                case 8 -> System.out.print("Осталось 8 часов");
                case 7 -> System.out.print("Осталось 7 часов");
                case 6 -> System.out.print("Осталось 6 часов");
                case 5 -> System.out.print("Осталось 5 часов");
                case 4 -> System.out.print("Осталось 4 часа");
                case 3 -> System.out.print("Осталось 3 часа");
                case 2 -> System.out.print("Осталось 2 часа");
                case 1 -> System.out.print("Остался 1 час");
                case 0 -> System.out.print("Осталось менее часа");
            }
        } else {
            System.out.print("Рабочий день закончился!");
        }
    }
}
