package Credit.Exercise1;


import java.util.Scanner;

public class HoleCloser {
    public static void main(String[] args) {

        /* чтобы круглая картонка закрывала прямоугольное отверстие, нужно, чтобы диаметр круга был больше либо равен
        диагонали прямоугольника
        диаметр круга равен радиусу круга, умноженному на два
        диагональ прямоугольника равна корню квадратному из суммы квадратов сторон прямоугольника */

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длину прямоугольного отверстия: ");
        int a = scanner.nextInt();
        System.out.print("Введите ширину прямоугольного отверстия: ");
        int b = scanner.nextInt();
        System.out.print("Введите радиус круглой картонки: ");
        int r = scanner.nextInt();
        System.out.println("Картонка с радиусом " + r
                + (r * 2 >= Math.sqrt(a * a + b * b) ? "" : " не")
                + " закрывает полностью отверстие размера " + a + " * " + b);
    }
}


