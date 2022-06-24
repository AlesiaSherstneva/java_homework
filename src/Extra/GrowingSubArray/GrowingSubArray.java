package Extra.GrowingSubArray;

import java.util.Arrays;

public class GrowingSubArray {
    public static void main(String[] args) {
        int[] firstArray = {2, 1, 4, 1, 2, 3, 4, 5, 6, 7, 3, 1};
        System.out.println("First array: " + Arrays.toString(firstArray));
        System.out.println("Max subarray: " + checkSortArrayLength(firstArray));
    }

    static int checkSortArrayLength(int[] array) {
        int lenght = 1, tempLength = 1;

        for (int i = 1; i < array.length - 1; i++) {
            while (array[i] >= array[i - 1]) {
                tempLength++;
                if (i < array.length - 1) {
                    i++;
                } else {
                    break;
                }
            }
            if (tempLength > lenght) {
                lenght = tempLength;
            }
            tempLength = 1;
        }
        return lenght;
    }
}
