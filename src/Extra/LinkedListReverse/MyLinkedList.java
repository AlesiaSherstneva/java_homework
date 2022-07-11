package Extra.LinkedListReverse;

import java.util.Arrays;

@SuppressWarnings("unused")
public class MyLinkedList {
    private Node head;
    private int size;

    public Node getHead() {
        return head;
    }

    public void add(int value) {
        if (head == null) {
            this.head = new Node(value);
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Node(value));
        }
        size++;
    }

    public int get(int index) {
        int currentIndex = 0;
        Node temp = head;
        while (temp != null) {
            if (currentIndex == index) {
                return temp.getValue();
            } else {
                temp = temp.getNext();
                currentIndex++;
            }
        }
        throw new IllegalArgumentException();
    }

    public void remove(int index) {
        if(index == 0) {
            head = head.getNext();
            size--;
            return;
        }
        int currentIndex = 0;
        Node temp = head;
        while (temp != null) {
            if (currentIndex == index - 1) {
                temp.setNext(temp.getNext().getNext());
                size--;
                return;
            } else {
                temp = temp.getNext();
                currentIndex++;
            }
        }
    }

    public String toString() {
        int[] result = new int[size];
        int index = 0;
        Node temp = head;
        while (temp != null) {
            result[index++] = temp.getValue();
            temp = temp.getNext();
        }
        return Arrays.toString(result);
    }

    public void reverse(Node head) {
        Node prev = null;
        Node temp = head;
        Node next;
        while (temp != null) {
            next = temp.getNext();
            temp.setNext(prev);
            prev = temp;
            temp = next;
        }
        head = prev;
        this.head = head;
    }


    private static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
