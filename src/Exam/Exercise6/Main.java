package Exam.Exercise6;

import Exam.Exercise6.Flowers.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Flower> bouquet = new ArrayList<>();
        System.out.println("Выберите цветы для букета: 1 - роза; 2 - гвоздика; 3 - тюльпан; " +
                "4 - лилия;  0 - букет закончен");
        Scanner scanner = new Scanner(System.in);

        boolean chosen = false;
        while (!chosen) {
            int number = scanner.nextInt();
            switch (number) {
                case 1 -> bouquet.add(new Rose());
                case 2 -> bouquet.add(new Carnation());
                case 3 -> bouquet.add(new Tulip());
                case 4 -> bouquet.add(new Lily());
                case 0 -> chosen = true;
            }
        }

        int allPrice = 0, maxTime = 0;
        Set<String> colors = new HashSet<>();

        for (Flower flower : bouquet) {
            colors.add(flower.getColor());
            allPrice += flower.getPrice();
            maxTime = Math.max(maxTime, flower.getTime());
        }

        System.out.println("В букете использованы цвета: " + colors + "");
        System.out.println("Итоговая стоимость букета: " + allPrice + " рублей");
        System.out.println("Весь букет завянет через " + maxTime + " дней");
    }
}
