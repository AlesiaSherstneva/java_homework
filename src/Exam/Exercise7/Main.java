package Exam.Exercise7;

public class Main {

    public static void main(String[] args) {

        Pair<String, Integer> pair = new Pair<>("one hundred", 100);
        System.out.print("Свойства класса: first = " + pair.first() + ", last = " + pair.last() + "\n");

        Pair<Integer, String> anotherPair = pair.swap();
        System.out.println("Делаем метод swap():");

        System.out.print("Свойства класса: first = " + anotherPair.first() + ", last = " + anotherPair.last() + "\n");

        pair.replaceFirst("one thousand");
        pair.replaceLast(1000);
        System.out.println("Заменяем свойства класса:");
        System.out.print("Свойства класса: first = " + pair.first() + ", last = " + pair.last() + "\n");

        anotherPair = pair.swap();
        System.out.println("Делаем метод swap():");

        System.out.print("Свойства класса: first = " + anotherPair.first() + ", last = " + anotherPair.last() + "\n");
    }
}
