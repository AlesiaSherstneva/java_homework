package Credit.Exercise13;

import java.io.*;

public class NumbersWriterAndReader {
    public static void main(String[] args) throws IOException {

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("numbers.dat"))) {
            for (int i = 0; i < 30; i++) {
                dos.writeInt((int) (Math.random() * 101));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        int sum = 0, counter = 0;

        System.out.println("Прочитанные из файла числа:");
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("numbers.dat"))) {
            while (true) {
                try {
                    int number = dataInputStream.readInt();
                    sum += number;
                    counter++;
                    System.out.print(number + " ");
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.printf("\nСреднее арифметическое: %.2f", (double) sum / counter);
    }
}
