package Extra.Sorting;

import java.util.Scanner;

public class Sorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Исходный массив: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100 + 1);
            System.out.print(array[i] + " ");
        }

        // решение через сумму

        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i+1]) {
                    isSorted = false;
                    array[i] += array[i+1];
                    array[i+1] = array[i] - array[i+1];
                    array[i] -= array[i+1];
                }
            }
        }

        System.out.println("\nОтсортированный массив по возрастанию: ");
        for (int j : array) {
            System.out.print(j + " ");
        }

        //решение через разность

        isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] < array[i+1]) {
                    isSorted = false;
                    array[i] -= array[i+1];
                    array[i+1] += array[i];
                    array[i] = array[i+1] - array[i];
                }
            }
        }

        System.out.println("\nОтсортированный массив по убыванию: ");
        for (int j : array) {
            System.out.print(j + " ");
        }
    }
}
