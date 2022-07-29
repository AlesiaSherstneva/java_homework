package Credit.Exercise05;

public class SymmetricalTimeSearcher {
    public static void main(String[] args) {
        int counter = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                String hour = i + Integer.toString(j);
                if (Integer.parseInt(hour) < 24) {
                    for (int k = 0; k < 6; k++) {
                        for (int l = 0; l < 10; l++) {
                            String reverseMin = l + Integer.toString(k);
                            if (hour.equals(reverseMin)) {
                                counter++;
                            }
                        }
                    }
                }
            }
        }
        System.out.printf("Симметричная комбинация на электронных часах показывается %d раз", counter);
    }
}
