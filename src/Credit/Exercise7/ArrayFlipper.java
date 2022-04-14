package Credit.Exercise7;

import java.util.Scanner;

public class ArrayFlipper {
    public static void main(String[] args) {
        
        /* так как в задании не был ограничен диапазон случайных чисел, я выбрала диапазон 10-99, 
        потому что на двузначных числах легче проследить правильность работы кода - они стоят симметрично */
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Исходный массив:");
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 90 + 10);
            System.out.print(array[i] + " ");
        }

        for (int i = 0; i <= n / 2; i++) {
            for (int j = n - 1; j >= n / 2; j--) {
                if (i + j == n - 1 && i != j) {
                    array[i] -= array[j];
                    array[j] += array[i];
                    array[i] = array[j] - array[i];
                }
            }
        }

        System.out.println("\nПеревёрнутый массив:");
        for (int element : array) {
            System.out.print(element + " ");
        }
    }
}
