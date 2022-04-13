package Credit;

/* чтобы круглая картонка закрывала прямоугольное отверстие, нужно, чтобы диаметр круга был больше либо равен
    диагонали прямоугольника
    диаметр круга равен радиусу круга, умноженному на два
    диагональ прямоугольника равна корню квадратному из суммы квадратов сторон прямоугольника
     */

import java.util.Scanner;

public class HoleCloser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длину прямоугольного отверстия: ");
        int a = scanner.nextInt();
        System.out.print("Введите ширину прямоугольного отверстия: ");
        int b = scanner.nextInt();
        System.out.print("Введите радиус круглой картонки: ");
        int r = scanner.nextInt();
        if (r * 2 >= Math.sqrt(a * a + b * b)) {
            System.out.println("Картонка с радиусом " + r + " закрывает полностью отверстие размера " + a + " * " + b);
        } else {
            System.out.println("Картонка с радиусом " + r + " не закрывает полностью отверстие размера " + a + " * " + b);
        }
    }
}
