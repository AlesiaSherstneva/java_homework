package Exam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumbersSorter {

    public static void main(String[] args) throws IOException {

        try (FileWriter fileWriter1 = new FileWriter("in1.txt")) {
            for (int i = 0; i < 1000; i++) {
                fileWriter1.write((int) (Math.random() * 100_001) + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (FileWriter fileWriter2 = new FileWriter("in2.txt")) {
            for (int i = 0; i < 1000; i++) {
                fileWriter2.write((int) (Math.random() * 100_001) + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Integer> numbers = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("in1.txt"))) {
            String result = bufferedReader.readLine();
            while (result != null) {
                numbers.add(Integer.parseInt(result));
                result = bufferedReader.readLine();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("in2.txt"))) {
            String result = bufferedReader.readLine();
            while (result != null) {
                numbers.add(Integer.parseInt(result));
                result = bufferedReader.readLine();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Collections.sort(numbers);

        try (FileWriter fileWriter3 = new FileWriter("out.txt")) {
            for (Integer number : numbers) {
                fileWriter3.write(number + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
