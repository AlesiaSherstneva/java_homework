package Extra.GrowingSubarray;

import java.util.Arrays;

public class GrowingSubarray {
    public static void main(String[] args) {
        int[] firstArray = {2, 1, 4, 1, 2, 3, 4, 5, 6, 7, 3, 1};
        int[] secondArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 11};
        int[] thirdArray = {1, 1, 1};

        System.out.println("First array: " + Arrays.toString(firstArray));
        System.out.println("Max subarray: " + checkSortArrayLength(firstArray));

        System.out.println("Second array: " + Arrays.toString(secondArray));
        System.out.println("Max subarray: " + checkSortArrayLength(secondArray));

        System.out.println("Third array: " + Arrays.toString(thirdArray));
        System.out.println("Max subarray: " + checkSortArrayLength(thirdArray));
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
