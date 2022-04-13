package Exam.Exercise4;

import java.util.Scanner;

public class MatrixCreator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер матрицы: ");
        int n = scanner.nextInt();
        int[][] myArray = new int[n][n];

        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                if (i == j || i + j == myArray.length - 1) {
                    myArray[i][j] = 0;
                } else if ((i < j && i + j < myArray.length - 1)
                        || (i > j && i + j > myArray.length - 1)) {
                    myArray[i][j] = (int) (Math.random() * 9 + 1);
                } else {
                    myArray[i][j] = (int) (Math.random() * (-9) - 1);
                }
            }
        }

        for (int[] ints : myArray) {
            for (int anInt : ints) {
                String str = String.format("%3d", anInt);
                System.out.print(str);
            }
            System.out.println();
        }

        int sum = 0;
        for (int[] ints : myArray) {
            for (int anInt : ints) {
                sum += anInt;
            }
        }

        System.out.println("Сумма всех элементов: " + sum);
        int counter = 0, middleOfSum = 0;
        for (int[] ints : myArray) {
            for (int anInt : ints) {
                if (anInt > sum && anInt != 0) {
                    counter++;
                    middleOfSum += anInt;
                }
            }
        }

        if (counter == 0) {
            System.out.println("В массиве нет элементов больше " + sum);
        } else {
            System.out.println("Среднее арифметическое всех элементов больше " + sum + " : " + middleOfSum / counter);
        }
    }
}
