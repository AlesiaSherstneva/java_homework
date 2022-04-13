package Exam.Exercise8;

import java.util.HashMap;
import java.util.Map;

public class EntriesCounter {

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 1, 4, 1, 5, 2, 4};
        Map<Integer, Integer> integerMap = arrayToMap(intArray);
        System.out.println(integerMap);

        Double[] doubleArray = {2.25, 3.25, 4.25, 1.25, 5.25, 1.25};
        Map<Double, Integer> doubleMap = arrayToMap(doubleArray);
        System.out.println(doubleMap);

        String[] stringArray = {"hello", "world", "bye", "world"};
        Map<String, Integer> stringMap = arrayToMap(stringArray);
        System.out.println(stringMap);
    }

    public static <K> Map<K, Integer> arrayToMap(K[] ks) {
        Map<K, Integer> map = new HashMap<>();
        for (K element : ks) {
            map.compute(element, (element1, counter) -> counter == null ? 1 : counter + 1);
        }
        return map;
    }
}
