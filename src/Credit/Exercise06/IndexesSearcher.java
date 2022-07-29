package Credit.Exercise06;

import java.util.Scanner;

public class IndexesSearcher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int[] array = new int[scanner.nextInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }

        System.out.printf("Массив из %d случайных чисел:", array.length);
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();

        int max = array[0], min = array[0], iMax = 0, iMin = 0;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
                iMax = i;
            } else if (min > array[i]) {
                min = array[i];
                iMin = i;
            }
        }

        System.out.printf("Максимальный элемент массива: %d. Его индекс: %d\n", max, iMax);
        System.out.printf("Минимальный элемент массива: %d. Его индекс: %d", min, iMin);
    }
}
