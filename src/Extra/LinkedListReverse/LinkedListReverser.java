package Extra.LinkedListReverse;

import java.util.Scanner;

public class LinkedListReverser {
    public static void main(String[] args) {
        System.out.print("Sample input:\n  ");
        Scanner scanner = new Scanner(System.in);
        int listSize = scanner.nextInt();

        MyLinkedList list = new MyLinkedList();
        for (int i = 1; i < listSize; i++) {
            list.add(i);
        }
        System.out.println("Sample output:");
        System.out.println("  Input:    " + list + "\n");

        System.out.print("  Expected: ");
        for (int i = listSize - 1; i > 0; i--) {
            if (i == listSize - 1) {
                System.out.print("[" + i + ",");
            } else if (i == 1) {
                System.out.print(" " + i + "]\n");
            } else {
                System.out.print(" " + i + ",");
            }
        }

        list.reverse(list.getHead());
        System.out.println("  Actual:   " + list);
    }
}
